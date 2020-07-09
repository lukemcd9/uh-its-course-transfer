function IdleConfig(IdleProvider) {
    IdleProvider.idle(5); // after 5 seconds of inactivity, marks user as idle.
    IdleProvider.timeout(5); // after 5 of being idle, time out user.
}

function IdleController($scope, $log, Idle, $uibModal, $window, App) {

    $scope.$on("IdleStart", () => {
        $log.debug("User idle.");
        $uibModal.open({
            templateUrl: "idleModal.html",
            controller: "IdleModalController"
        });
    });

    $scope.$on("IdleEnd", () => {
        $log.debug("User no longer idle.");
    })

    $scope.$on("IdleTimeout", () => {
        $log.debug("User timed out.");
        //$window.location = "/transferdatabase/logout";
        $window.location = App.URL.LOGOUT;
    });
}

creditxferApp.controller("IdleController", IdleController)
    .config(IdleConfig).run((Idle) => Idle.watch());

function IdleModalController($scope) {
    $scope.countdown = 5;
}
creditxferApp.controller("IdleModalController", IdleModalController);