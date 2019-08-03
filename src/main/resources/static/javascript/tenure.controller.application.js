(function() {

    function ApplicationJsController($scope, $http, $window, $uibModal, dataProvider) {
        const URL_LOAD_TYPE = '/tenure/api/application/types';
        const URL_APP_ADD = '/tenure/api/application/add';
        $scope.applications = [];
        $scope.applicationTypes = [];
        $scope.appFiles = [];

        $scope.init = function(apps) {
            $scope.applications = apps;
        }

        $scope.init = function(apps, appTypes) {
            $scope.applications = apps;
            $scope.applicationTypes = appTypes;
        }

        $scope.initTypes = function() {
            dataProvider.loadData(function(data) {
                $scope.types = data;
            }, URL_LOAD_TYPE);
        };

        $scope.initAppfiles = function(appFiles) {
            $scope.appFiles = appFiles;
        }

        $scope.add = function(apps, appTypes) {
            $scope.types = appTypes;
            $scope.applicationType = appTypes[0];

            var modalInstance = $uibModal.open({
                animation: true,
                templateUrl: 'ApplicationAddModalTemplateId',
                controller: 'ApplicationAddDialog',
                scope: $scope,
                resolve: {
                    uhUuid: function() {
                        return $scope.uhUuid;
                    },
                    applicationType: function() {
                        return $scope.applicationType;
                    }
                }
            });
            modalInstance.result.then(function(data) {
                dataProvider.saveData(function(data) {
                    $scope.applications.unshift(data);
                }, URL_APP_ADD, data);
            }, function() {
                console.log('Modal (add) dismissed at: ' + new Date());
            });
        };

        /*
         * The next three functions are just an ugly hack so that the Spring
         * Controllers can send data to the thymeleaf pages using model
         * attributes.
         */
        $scope.wApplications = function() {
            return $window.applications;
        }
        $scope.wApplicationTypes = function() {
            return $window.applicationTypes;
        }
        $scope.wAppFiles = function() {
            return $window.appFiles;
        }
    }
    tenureApp.controller("ApplicationJsController", ApplicationJsController);

    function ApplicationAddDialog($scope, $http, $uibModalInstance, dataProvider, uhUuid, applicationType) {
        const URL_LOOKUP_NAME = '/tenure/api/application/lookupName';
        $scope.mydisabled = true;
        $scope.uhUuid = uhUuid;
        $scope.applicationType = applicationType;

        $scope.lookupName = function() {
            var search = $scope.search;
            dataProvider.loadData(function(data) {
                $scope.name = data.name;
                $scope.uhUuid = data.uhUuid;
                $scope.mydisabled = false;

                if ($scope.uhUuid == null || $scope.uhUuid == "") {
                    $scope.mydisabled = true;
                    $scope.name = "User not found, please try again";
                }
            }, URL_LOOKUP_NAME + '/?search=' + search);
        };

        $scope.ok = function() {
            var dataObj = {
                uhUuid: $scope.uhUuid,
                applicationType: $scope.applicationType
            };

            $uibModalInstance.close(dataObj);
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    }
    tenureApp.controller("ApplicationAddDialog", ApplicationAddDialog);

})();
