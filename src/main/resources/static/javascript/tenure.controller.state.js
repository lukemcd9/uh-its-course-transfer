(function() {

    function StateJsController($scope, dataProvider) {
        const URL_LOAD = '/tenure/api/states';
        $scope.states = [];

        $scope.init = function() {
            $scope.loadData();
        };

        $scope.loadData = function() {
            dataProvider.loadData(function(data) {
                $scope.states = data;
            }, URL_LOAD);
        }
    }
    tenureApp.controller("StateJsController", StateJsController);

})();
