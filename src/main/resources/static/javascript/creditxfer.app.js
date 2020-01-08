"use strict"

var creditxferApp = angular.module("creditxferApp", ["ui.bootstrap", "ui.select", "ngSanitize"]);

function CreditxferJsController($scope, dataProvider) {
  var institutionUrl = "api/institutions";
  var catalogUrl = "api/catalog";
  $scope.institutions = [];
  $scope.coursesSourceFiltered = [];
  $scope.subjects = [];
  $scope.available = [];
  $scope.catalog = [];
  $scope.selected = "";

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

    dataProvider.loadData(function(response) {
      $scope.catalog = response.data;
    }, catalogUrl)
  }

  $scope.filterBySourceInstitution = function(source) {
    console.log(source);
    $scope.subjects = [];
    $scope.available = [];
    $scope.catalog.forEach(function(c) {
      $scope.course = c;
      if ($scope.coursesSourceFiltered.indexOf(c) < 0 && c.sourceInstitutionCode === source) {
        $scope.coursesSourceFiltered.push(c);
      }
    });
    $scope.coursesSourceFiltered.sort();
    $("#target").val("default").selectpicker("refresh");
  }

  $scope.filterSubjects = function(target) {
    $scope.subjects = [];
    $scope.available = [];
    $scope.coursesSourceFiltered.forEach(function(c) {
      $scope.course = c;
      var s = c.subjectCodeEquiv;
      if ($scope.subjects.indexOf(s) < 0 && c.mifValue === target) {
        $scope.subjects.push(s);
      }
    });
    $scope.subjects.sort();
  }

<<<<<<< HEAD
  $scope.filterCourses = function(mifValue, subject) {
    console.log(mifValue);
=======
  $scope.filterCourses = function(subject, target) {
>>>>>>> 16df85c... Implement catalog data into search bar, "Transferring from" field usable.
    $scope.available = [];
    $scope.coursesSourceFiltered.forEach(function(c) {
      $scope.course = c;
      if ($scope.available.indexOf(c) < 0 && c.subjectCodeEquiv === subject && c.mifValue === target) {
        $scope.available.push(c);
      }
    });
  }

  $scope.showCourse = function(course) {
    $scope.course = course;
    $("#course").modal();
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
        $log.error('Error in dataProvider; status: ', status);
      });
    }
  };
});

creditxferApp.controller("CreditxferJsController", CreditxferJsController);

creditxferApp.filter('propsFilter', function() {
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

// For ngSanitize deprecated method 'lowercase'
angular.module("creditxferApp").config(function() {
  angular.lowercase = angular.$$lowercase;
});