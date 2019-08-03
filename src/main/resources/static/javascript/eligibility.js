function approvalCheck(selectObject) {
    if (selectObject.value == "0") {
        document.getElementById("approval-upload").style.display = 'none';
        document.getElementById("approval-link").style.display = 'none';        
    } else {
        document.getElementById("approval-upload").style.display = 'block';
        document.getElementById("approval-link").style.display = 'none';
    }
}

function enableSaveCheck() {
    alertSaved(false);
    if (document.getElementById("campusCode").selectedIndex != 0 &&
        document.getElementById("subject").value != "" &&
        document.getElementById("subject").value.length > 0 &&
        document.getElementById("initialRankCode").selectedIndex != 0 &&
        document.getElementById("initialDate").value != "" &&
        document.getElementById("initialDate").value.length > 5 &&
        document.getElementById("initialTypeCode").selectedIndex != 0 &&
        document.getElementById("currentRankCode").selectedIndex != 0 &&
        document.getElementById("currentApptDate").value != "" &&
        document.getElementById("currentApptDate").value.length > 5 &&
        document.getElementById("currentTypeCode").selectedIndex != 0
        // consideration has acceptable default
       ) {
        document.getElementById("save-button").disabled = '';
        document.getElementById("alert-saved").style.display = 'none';
    } else {
        document.getElementById("save-button").disabled = 'disabled';
    }
}

function alertSaved(on) {
    if (on) {
        document.getElementById("alert-saved").style.display = 'block';
    } else {
        document.getElementById("alert-saved").style.display = 'none';
    }
}

function alertSaving(on) {
    if (on) {
        document.getElementById("alert-saving").style.display = 'block';
    } else {
        document.getElementById("alert-saving").style.display = 'none';
    }
}

function disableSaveButton() {
    document.getElementById("save-button").disabled = 'disabled';    
}

function alertSuccess() {
    alertSaving(false);
    alertSaved(true);
}

function alertFailure() {
    alertSaving(false);
    alertSaved(false);
}

function alertRequestFailed(data, status, request) {
    alert('Request failed, ' + request + '.  Returned status of ' + status + '\nData: ' + JSON.stringify(data));
}

function addEligibility() {
    alertSaving(true);
    $.ajax({url : '/tenure/api/application-eligibility',
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(jQuery('#eligibility').serializeJSON())
    })
    .then(
        function success(data) {
            alertSuccess();
            disableSaveButton();
//            alert(data + data.id);
            document.getElementById("application_eligibility_id").value = data.id;
            // TODO save notification
        },

        function fail(data, status) {
            alertFailure();
            alertRequestFailed(data, status, "Add Eligibility");
        }
    );
}

function addEligibilityAlert() {
    $.ajax({url : '/tenure/api/application-eligibility',
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(jQuery('#eligibility').serializeJSON())
    })
    .then(
        function success(data) {
            disableSaveButton();
            alertSuccess();
//            alert('Eligibility Saved');
        },

        function fail(data, status) {
            alertFailure();
            alertRequestFailed(data, status, "Add Eligibility File");
        }
    );
}

function addEligibilityFile() {
    addEligibility();
    disableSaveButton();
    document.getElementById("eligibilityfile").submit();
}

function deleteFile() {
    deleteEligibilityFile(document.getElementById("application").value);
}

function deleteEligibilityFile(applicationId) {
    $.ajax({url : '/tenure/api/eligibility-file/delete/' + applicationId,
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(jQuery('#eligibility').serializeJSON())
    })
    .then(
        function success(data) {
//            if (document.getElementById("considerationCode").value == "before") {
//                beforeWrite();
//            } else {
//                afterWrite();
//            }
        
//            alert('Eligibility Saved');
        },

        function fail(data, status) {
            alertRquestFailed(data, status, "Delete Elibigility File");
        }
    );
}

$(document).ready(function() {
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $(".add_field_button"); //Add button ID
    var x = 1; //initial text box count
    $(add_button).click(function(e) {
        e.preventDefault(); if(x < max_fields) {
            x++;$(wrapper).append('<div><input id="append" type="text" name="mytext[]"/><a href="#" class="remove_field"><button name="remove_levels" value="delete" class="btn btn-secondary glyphicon glyphicon-trash btn-lg background-color" style="padding-left:10px;"></button></a></div>' );
        }
    });
   
    $(wrapper).on("click",".remove_field", function(e) {
        e.preventDefault();
        $(this).parent('div').remove();
        x--;
    })
});

function toggler(divId) {
    $("#" + divId).toggle();
}

$(document).ready(function() {
    $('#reason').on('change', function() {
        if ( this.value == '1') {
            $("#comment").show();
        } else {
            $("#comment").hide();
        }
    });
});

$(function () {
    $("ol.dragable").sortable();
});
