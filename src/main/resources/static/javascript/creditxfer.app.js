"use strict"

var creditxferApp = angular.module("creditxferApp", ["ui.bootstrap", "ui.select", "ngSanitize"]);

function CreditxferJsController($scope, dataProvider) {
  var institutionUrl = "api/institutions";
  $scope.institutions = [];
  $scope.subjects = [];
  $scope.available = [];
  $scope.attributes = [];
  $scope.catalog = [];
  $scope.selected = "";
  $scope.attribute = "";
  $scope.startDescription = "";
  $scope.endDescription = "";

  $scope.colleges = [{description:"UH Manoa", mifValue: "MAN"},
    {description: "UH Hilo", mifValue: "HIL"},
    {description: "UH West O'ahu", mifValue: "WOA"},
    {description: "Hawai'i Community College", mifValue: "HAW"},
    {description: "Honolulu Community College", mifValue: "HON"},
    {description: "Kapi'olani Community College", mifValue: "KAP"},
    {description: "Kaua'i Community College", mifValue: "KAU"},
    {description: "Leeward Community College", mifValue: "LEE"},
    {description: "UH Maui College", mifValue: "MAU"},
    {description: "Windward Community College", mifValue: "WIN"}];

  $scope.init = function() {
    $scope.loadData();
  }

  $scope.loadData = function() {
    dataProvider.loadData(function(response) {
      $scope.institutions = response.data;
    }, institutionUrl);
  }

  $scope.loadCatalog = function(source, target) {
    $scope.subjects = [];
    $scope.available = [];
    $scope.catalog = [];
    var catalogUrl = "api/catalog/source/" + source + "/target/" + target;
    dataProvider.loadData(function(response) {
      $scope.catalog = response.data;
      $scope.catalog.forEach(function(c) {
        $scope.course = c;
        var s = c.subjectCodeTrans;
        if ($scope.subjects.indexOf(s) < 0) {
          $scope.subjects.push(s);
        }
      });
      $scope.subjects.sort();
    }, catalogUrl)
  }

  $scope.loadAttributes = function(mif, subject) {
    var attributeUrl = "api/courses/mif/" + mif + "/subject/" + subject;
    dataProvider.loadData(function(response) {
      $scope.attributes = response.data;
    }, attributeUrl)
  }

  $scope.findAttribute = function(course) {
    var filteredAttributes = $scope.attributes.filter(function (a) {
      return a.courseNumber === course.courseNumberEquiv && a.start === course.academicPeriodStart;
    })

    return filteredAttributes.length > 0;
  }

  $scope.filterCourses = function(subject) {
    $scope.available = [];
    $scope.catalog.forEach(function(c) {
      $scope.course = c;
      if ($scope.available.indexOf(c) < 0 && c.subjectCodeTrans === subject) {
        $scope.available.push(c);
      }
    });
  }

  $scope.showCourse = function(course) {
    var filteredAttributes = $scope.attributes.filter(function(a) {
      return a.courseNumber === course.courseNumberEquiv && a.start === course.academicPeriodStart;
    })

    $scope.course = course;

    if (filteredAttributes.length > 0) {
      var filteredCourse = filteredAttributes[0];

      $scope.attribute = filteredCourse.attribute;
      $scope.startDescription = filteredCourse.startDescription;
      $scope.endDescription = filteredCourse.endDescription;

      $("#course").modal();
    }
  }

  $scope.headerColor = function(inst) {
    switch(inst) {
      case "MAN":
        $scope.color = "man";
        break;
      case "HIL":
        $scope.color = "hil";
        break;
      case "WOA":
        $scope.color = "woa";
        break;
      case "HAW":
        $scope.color = "haw";
        break;
      case "HON":
        $scope.color = "hon";
        break;
      case "KAP":
        $scope.color = "kap";
        break;
      case "KAU":
        $scope.color = "kau";
        break;
      case "LEE":
        $scope.color = "lee";
        break;
      case "MAU":
        $scope.color = "mau";
        break;
      case "WIN":
        $scope.color = "win";
      default:
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