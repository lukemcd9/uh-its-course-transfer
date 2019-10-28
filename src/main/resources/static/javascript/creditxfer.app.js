"use strict"

var creditxferApp = angular.module("creditxferApp", ["ui.bootstrap", "ui.select", "ngSanitize"]);

function InstitutionJsController($scope, dataProvider) {
  var url = "api/institutions";
  $scope.institutions = [];
  $scope.selected = "";
  $scope.states = [];

  $scope.init = function() {
    $scope.loadData();
  }

  $scope.loadData = function() {
    dataProvider.loadData(function(response) {
      $scope.institutions = response.data.data;
      $scope.institutions.forEach(function(i) {
        $scope.institution = i;
        var s = i.stateProvince;
        if ($scope.states.indexOf(s) < 0) {
          $scope.states.push(s);
        }
      });
      $scope.states.sort();
    }, url);
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

creditxferApp.controller("InstitutionJsController", InstitutionJsController);

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