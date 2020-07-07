function IdleConfig(IdleProvider, KeepaliveProvider) {
    IdleProvider.idle(5); // after 5 seconds of inactivity, marks user as idle.
    IdleProvider.timeout(5); // after 5 of being idle, time out user.
    KeepaliveProvider.interval(2); // trigger keep alive every 2 seconds.
}

function IdleController($scope, Idle, $uibModal) {

    $scope.$on("IdleStart", () => {
        console.log("User idle.");
    });

    $scope.$on("IdleEnd", () => {
        console.log("User no longer idle.");
    })

    $scope.$on("IdleTimeout", () => {
        console.log("User timed out.");
        $uibModal.open({
            templateUrl: "idleModal.html",
        });
    });
}

creditxferApp.controller("IdleController", IdleController).config(IdleConfig).run((Idle) => Idle.watch());