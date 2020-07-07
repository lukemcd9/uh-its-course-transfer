function IdleConfig(IdleProvider, KeepaliveProvider) {
    IdleProvider.idle(5); // after 30 seconds of inactivity, marks user as idle.
    IdleProvider.timeout(5);
    KeepaliveProvider.interval(2);
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