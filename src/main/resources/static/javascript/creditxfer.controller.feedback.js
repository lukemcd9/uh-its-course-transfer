function FeedbackController($scope){

    $scope.send = function(e) {
        e.preventDefault();
        console.log("Clicked!");
    }
}

creditxferApp.controller("FeedbackController", FeedbackController);