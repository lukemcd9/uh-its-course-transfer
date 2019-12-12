"use strict"

var creditxferApp = angular.module("creditxferApp", ["ui.bootstrap", "ui.select", "ngSanitize"]);

function CreditxferJsController($scope, dataProvider) {
  var institutionUrl = "api/institutions";
  var courseUrl = "api/courses";
  $scope.institutions = [];
  $scope.courses = [];
  $scope.subjects = [];
  $scope.available = [];
  $scope.selected = "";

  $scope.init = function() {
    $scope.loadData();
  }

  $scope.loadData = function() {
    dataProvider.loadData(function(response) {
      $scope.institutions = response.data;
    }, institutionUrl);

    dataProvider.loadData(function(response) {
      $scope.courses = response.data;
    }, courseUrl)
  }

  $scope.filterSubjects = function(mifValue) {
    $scope.subjects = [];
    $scope.available = [];
    $scope.courses.forEach(function(c) {
      $scope.course = c;
      var s = c.subject;
      if ($scope.subjects.indexOf(s) < 0 && c.mifValue === mifValue) {
        $scope.subjects.push(s);
      }
    });
    $scope.subjects.sort();
  }

  $scope.filterCourses = function(mifValue, subject) {
    $scope.available = [];
    $scope.courses.forEach(function(c) {
      $scope.course = c;
      if ($scope.available.indexOf(c) < 0 && c.mifValue === mifValue && c.subject === subject) {
        $scope.available.push(c);
      }
    });
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