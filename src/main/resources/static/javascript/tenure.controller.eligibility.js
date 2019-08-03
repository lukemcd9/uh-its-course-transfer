(function() {

    function EligibilityJsController($scope, $http, $window, dataProvider) {
        const URL_ELIGIBILITY_LOAD = '/tenure/api/eligibility';
        const URL_ELIGIBILITIES_LOAD = '/tenure/api/eligibilities';
        const URL_ELIGIBILITY_FILE_LOAD = '/tenure/api/eligibility-file';
        const URL_ELIGIBILITIES_FILES_LOAD = '/tenure/api/eligibilities-files';
        $scope.eligibilities = [];
        $scope.eligibilityFiles = [];

        $scope.init = function(eligibilities, eligibilityFiles) {
            $scope.eligibilities = eligibilities;
            $scope.eligibilityFiles = eligibilityFiles;
            $scope.loadData();
        };

        $scope.loadFileData = function() {
            var appId = document.getElementById("application").value;
            dataProvider.loadData(function(data) {
                $scope.eligibilityFiles = data;
            }, URL_ELIGIBILITY_FILE_LOAD + "/" + appId);
        };

        $scope.loadData = function() {
            var appId = document.getElementById("application").value;
            dataProvider.loadData(function(data) {
                $scope.eligibilities = data;
                if (data !=null && data != "") {
                    document.getElementById("campusCode").value = data.campusCode;
                    document.getElementById("subject").value = data.subject;
                    document.getElementById("initialRankCode").value = data.initialRankCode;
                    document.getElementById("initialDate").value = data.initialDate;
                    document.getElementById("initialTypeCode").value = data.initialTypeCode;
                    document.getElementById("currentRankCode").value = data.currentRankCode;
                    document.getElementById("currentApptDate").value = data.currentApptDate;
                    document.getElementById("currentTypeCode").value = data.currentTypeCode;
                    document.getElementById("considerationCode").value = data.considerationCode;
                    if (data.considerationCode != "0") { 
                        if ($scope.eligibilityFiles != null && $scope.eligibilityFiles != "") {
                            $scope.approvalLink();
                        } else {
                            $scope.approvalUpload();
                        }
                        alertSaved(true);
                    }
                } else {
                    if (document.getElementById("appcampus").value != "SW") {
                        document.getElementById("campusCode").value = document.getElementById("appcampus").value;
                    }
                }
            }, URL_ELIGIBILITY_LOAD + "/" + appId);
        };
        

        $scope.approvalLink = function() {
            document.getElementById("approval-upload").style.display = 'none;';
            document.getElementById("approval-show").style.display = 'block';
//            document.getElementById("approval-link").innerHTML = $scope.eligibilityFiles.fileName;
//            document.getElementById("approval-link").href = $scope.eligibilityFiles.filePath;
        };

        $scope.approvalUpload = function() {
            document.getElementById("approval-upload").style.display = 'block';
            document.getElementById("approval-show").style.display = 'none';
//            document.getElementById("approval-link").innerHTML = "";
//            document.getElementById("approval-link").href = "";
        };

        $scope.inits = function() {
            dataProvider.loadData(function(data) {
                $scope.eligibilities = data;
            }, URL_ELIGIBILITIES_LOAD);
        };

        $scope.initFiles = function() {
            dataProvider.loadData(function(data) {
                $scope.eligibilityFiles = data;
            }, URL_ELIGIBILITIES_FILES_LOAD);
        };

        /*
         * The next two functions are just an ugly hack so that the Spring
         * Controllers can send data to the thymeleaf pages using model
         * attributes.
         */
        $scope.wEligibilities = function() {
            return $window.eligibilities;
        }
        $scope.wEligibilityFiles = function() {
            return $window.eligibilityFiles;
        }
    }
    tenureApp.controller("EligibilityJsController", EligibilityJsController);
})();
