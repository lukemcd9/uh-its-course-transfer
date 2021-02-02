"use strict"

var creditxferApp = angular.module("creditxferApp", 
                                   ["ui.bootstrap", 
                                    "ui.select", 
                                    "ngSanitize", 
                                    "ngIdle"]);


creditxferApp.constant("App", {
    URL: {
        COURSE_SOURCE_BASE: "/transferdatabase/api/courses/source/",
        INSTITUTIONS: "/transferdatabase/api/institutions",
        LOGOUT: "/transferdatabase/logout",
        KEEP_ALIVE: "/transferdatabase/ping"
    }
});


function CreditxferJsController($scope, App, dataProvider, $window) {
  $scope.institutions = [];
  $scope.sources = [];
  $scope.targets = [];
  $scope.subjects = [];
  $scope.available = [];
  $scope.attributes = [];
  $scope.catalog = [];
  $scope.selected = "";
  $scope.loading = true;

  $scope.init = function() {
    $scope.loadData();
    $scope.catalogCode = $window.catalogCode;
    $scope.uhCampus = $window.uhCampus;
    $scope.subject = $window.subject;

    if ($scope.catalogCode && $scope.uhCampus && $scope.subject) {
      $scope.loadTargets($scope.catalogCode.toUpperCase());
      $scope.loadCatalog($scope.catalogCode.toUpperCase(), $scope.uhCampus.toUpperCase());
      $scope.loadAttributes($scope.catalogCode.toUpperCase(), $scope.uhCampus.toUpperCase());
    }
  }

  $scope.loadData = function() {
    $scope.loadMessage = true;
    dataProvider.loadData(function(response) {
      $scope.institutions = response.data;
      const map = new Map();
      $scope.institutions.forEach(function(i) {
        if (!map.has(i.description)) {
          map.set(i.description, true);
          $scope.sources.push(i);
        }
      })
      $scope.load($scope.sources);
    }, App.URL.INSTITUTIONS);
  }

  $scope.loadTargets = function(source) {
    $scope.targets = [{ mifDescription: "All UH Campuses", mifValue: "alluh" }];
    const map = new Map();
    $scope.institutions.forEach(function(i) {
      if (!map.has(i.mifDescription) && i.code === source) {
        map.set(i.mifDescription, true);
        $scope.targets.push(i);
      }
    })
    $scope.targets.sort((a, b) => a.mifDescription.localeCompare(b.mifDescription));
  }

  $scope.loadCatalog = function(source, target) {
    $scope.subjects = [];
    $scope.available = [];
    $scope.catalog = [];
    $scope.loadMessage = true;
    var catalogUrl = "/transferdatabase/api/catalog/source/" + source + "/target/" + target;
    dataProvider.loadData(function(response) {
      $scope.catalog = response.data;
      for (var i = 0; i < $scope.catalog.length; i++) {
        $scope.catalog[i].forEach(function(c) {
          var s = c.subjectCodeTrans;
          if ($scope.subjects.indexOf(s) < 0) {
            $scope.subjects.push(s);
          }
        });
      }
      $scope.subjects.sort();
      $scope.load($scope.subjects);
    }, catalogUrl)
  }

  $scope.filterCourses = function(subject) {
    $scope.available = [];
    for (var i = 0; i < $scope.catalog.length; i++) {
      $scope.catalog[i].forEach(function(c) {
        if ($scope.available.indexOf(c) < 0 && c.subjectCodeTrans === subject) {
          $scope.available.push(c);
        }
      });
    }

    $scope.available.forEach(function(c) {
      $scope.findConnectedCourseRecursive(c);
    })

    for (var i = 0; i < $scope.available.length; i++) {
      if ($scope.available[i].sequenceNumber !== 1 && $scope.available[i].sequenceNumber !== null) {
        $scope.available.splice(i, 1);
        i -= 1;
      }
    }

    $scope.available.sort((a, b) => a.courseNumberTrans.localeCompare(b.courseNumberTrans));
  }

  $scope.loadAttributes = function(source, target, subject) {
    var attributeUrl = "/transferdatabase/api/courses/source/" + source + "/target/" + target + "/subject/" + subject;
    dataProvider.loadData(function(response) {
      $scope.attributes = response.data;
    }, attributeUrl)
  }

  $scope.filterAttributes = function(course) {
    var filteredAttributes = [];
    var temp = $scope.attributes.filter(function(a) {
      return a.sourceInstitutionCode === course.sourceInstitutionCode
          && a.mifValue === course.mifValue
          && a.subjectCodeTrans === course.subjectCodeTrans
          && a.courseNumberTrans === course.courseNumberTrans
          && course.subjectCodeEquiv.includes(a.subjectCodeEquiv)
          && course.courseNumberEquiv.includes(a.courseNumberEquiv)
          && a.academicPeriodStart === course.academicPeriodStart
    })

    const map = new Map();
    temp.forEach(function(a) {
      if (!map.has(a.equivCourseAttribute)) {
        map.set(a.equivCourseAttribute, true);
        filteredAttributes.push(a);
      }
    })
    filteredAttributes.sort((a, b) => a.equivCourseAttribute.localeCompare(b.equivCourseAttribute));
    return filteredAttributes;
  }

  $scope.findAttribute = function(course) {
    var filteredAttributes = $scope.filterAttributes(course);
    return filteredAttributes.length > 0;
  }

  $scope.showCourse = function(course) {
    var filteredAttributes = $scope.filterAttributes(course);
    $scope.course = course;

    if (filteredAttributes.length > 0) {
      $scope.courseAttr = filteredAttributes;
      $("#course")
      .modal();
    }
  }

  $scope.load = function(arr) {
    if (arr.length === 0) {
      $scope.loading = true;
    } else {
      $scope.loading = false;

      if ($scope.catalogCode && $scope.uhCampus && $scope.subject) {ß
        $scope.sources.selected = $scope.sources.find(source =>
            source.code.toUpperCase() === $scope.catalogCode.toUpperCase());

        $scope.targets.selected = $scope.sources.find(source =>
            source.mifValue.toUpperCase() === $scope.uhCampus.toUpperCase());

        $scope.subjects.selected = $scope.subject;
        $scope.filterCourses($scope.subjects.selected);
      }
    }
  }

  $scope.findConnectedCourseRecursive = function(course) {
    if (course.sequenceNumber === 1) {
      var values = $scope.findConnectedCourseHelper(course, course.sequenceNumber + 1);
      course.courseNumberEquiv = values.courseNumber;
      course.equivCreditsUsed = values.credits;
    }
  }

  $scope.findConnectedCourseHelper = function(course, sequence) {
    $scope.available.forEach(function(c) {
      if (c.sourceInstitutionCode === course.sourceInstitutionCode
          && c.mifValue === course.mifValue
          && c.subjectCodeTrans === course.subjectCodeTrans
          && c.courseNumberTrans === course.courseNumberTrans
          && c.courseTitleTrans === course.courseTitleTrans
          && c.academicPeriodStart === course.academicPeriodStart
          && c.sequenceNumber !== course.sequenceNumber)
      {
        if (c.sequenceNumber === sequence) {
          var values = $scope.findConnectedCourseHelper(c, sequence + 1);
          if (values.connector === "A") {
            course.courseNumberEquiv += " and<br/>";
            course.equivCreditsUsed += values.credits;
          } else if (values.connector === "O") {
            course.subjectCodeEquiv += "<br/> or"
            course.courseNumberEquiv += "<br/><br/>";
          }
          course.subjectCodeEquiv += "<br/>" + values.subject;
          course.courseNumberEquiv += values.courseNumber;
        }
      }
    })
    return {
      subject: course.subjectCodeEquiv,
      courseNumber: course.courseNumberEquiv,
      credits: course.equivCreditsUsed,
      connector: course.connector
    };
  }

  $scope.targetName = function(inst) {
    switch (inst) {
      case "MAN":
        return "University of Hawaii at Manoa";
      case "HIL":
        return "University of Hawaii at Hilo";
      case "WOA":
        return "University of Hawaii West Oahu";
      case "HAW":
        return "Hawaii Community College";
      case "HON":
        return "Honolulu Community College";
      case "KAP":
        return "Kapiolani Community College";
      case "KAU":
        return "Kauai Community College";
      case "LEE":
        return "Leeward Community College";
      case "MAU":
        return "University of Hawaii Maui College"
      case "WIN":
        return "Windward Community College";
      default:
        return "";
    }
  }
}

creditxferApp.factory("dataProvider", function($http, $log) {
  return {
    loadData: function(callback, url) {
      $http.get(encodeURI(url)).then(callback, function(data, status) {
        $log.error("Error in dataProvider; status: ", status);
      });
    }
  };
});

creditxferApp.controller("CreditxferJsController", CreditxferJsController);

creditxferApp.filter("propsFilter", function() {
  return function(items, props) {
    var out = [];
    if(!props.description.length){
      return out;
    }

    if (angular.isArray(items)) {
      items.forEach(function(item) {
        var itemMatches = false;

        var keys = Object.keys(props);
        for (var i = 0; i < keys.length; i++) {
          var prop = keys[i];
          var text = props[prop].toLowerCase();
          if (item[prop].toString().toLowerCase().indexOf(text) !== -1) {
            itemMatches = true;
            break;
          }
        }

        if (itemMatches) {
          out.push(item);
        }
      });
    } else {
      // Let the output be the input untouched
      out = items;
    }

    return out;
  }
});

function FeedbackController($scope){

  $scope.submit = function(form) {

  }
}

creditxferApp.controller("FeedbackController", FeedbackController);

// For ngSanitize deprecated method "lowercase"
angular.module("creditxferApp").config(function() {
  angular.lowercase = angular.$$lowercase;
});