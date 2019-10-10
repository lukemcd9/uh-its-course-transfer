"use strict"

var creditxferApp = angular.module("creditxferApp", ["ui.bootstrap"]);

function InstitutionJsController($scope, dataProvider) {
  var url = "api/institutions";
  $scope.institutions = [];
  $scope.selected = "";

  $scope.init = function() {
    $scope.loadData();
  }

  $scope.loadData = function() {
    dataProvider.loadData(function(response) {
      $scope.institutions = response.data.data;
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
