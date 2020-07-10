function IdleConfig(IdleProvider, KeepaliveProvider, App) {
    IdleProvider.idle(5); // after 5 seconds of inactivity, marks user as idle.
    IdleProvider.timeout(5); // after 5 of being idle, time out user.
    IdleProvider.interrupt("DOMMouseScroll mousewheel keydown mousedown"); // what event that can interrupt.

    KeepaliveProvider.http(App.URL.KEEP_ALIVE);
    KeepaliveProvider.interval(10); // every 10 seconds a keepalive event is broadcast and sends a request to KEEP_ALIVE url
}

function IdleController($scope, $log, Idle, $uibModal, $window, App) {
    let modal;

    $scope.$on("IdleStart", () => {
        $log.debug("User idle.");
        modal = $uibModal.open({
            templateUrl: "idleModal.html",
            controller: "IdleModalController"
        });
    });

    $scope.$on("IdleEnd", () => {
        $log.debug("User no longer idle.");
        modal.dismiss("cancel")
    })

    $scope.$on("IdleTimeout", () => {
        $log.debug("User timed out.");
        $window.location = App.URL.LOGOUT;
    });

    $scope.$on("KeepaliveResponse", (event, response, status) => {
        $log.debug(`Keepalive Data: ${response.data}`);
    });
}

creditxferApp.controller("IdleController", IdleController)
    .config(IdleConfig).run((Idle) => Idle.watch());

function IdleModalController($scope) {
    $scope.countdown = 5;
}

creditxferApp.controller("IdleModalController", IdleModalController);