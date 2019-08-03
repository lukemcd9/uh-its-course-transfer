(function() {

    function AppointmentJsController($scope, $window, dataProvider) {
        const URL_LOAD_RANK = '/tenure/api/appointment/ranks';
        const URL_LOAD_TYPE = '/tenure/api/appointment/types';
        $scope.types = [];
        $scope.ranks = [];

        $scope.init_rank = function() {
            $scope.loadRankData();
        };

        $scope.init_type = function() {
            $scope.loadTypeData();
        };

        $scope.loadTypeData = function() {
            dataProvider.loadData(function(data) {
                $scope.types = data;
            }, URL_LOAD_TYPE);
        };

        $scope.loadRankData = function() {
            dataProvider.loadData(function(data) {
                $scope.ranks = data;
            }, URL_LOAD_RANK);
        };
    }
    tenureApp.controller("AppointmentJsController", AppointmentJsController);

})();
