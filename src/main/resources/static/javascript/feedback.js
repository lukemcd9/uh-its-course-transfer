const init = function(){
    document.getElementById('submit-button').addEventListener('click', send);
}

const send = function(ev){
    ev.preventDefault();
    ev.stopPropagation();
    //or the click will travel to the form and the form will submit
    let fails = validate();
    if(fails.length === 0){
        //good to go
        document.getElementById('feedbackForm').submit();
    }else{

        fails.forEach(function(obj){
            let field = document.getElementById(obj.input);
            field.parentElement.classList.add('error');
            field.parentElement.setAttribute('data-errormsg', obj.msg);
        })
    }
}

const validate = function(ev){

    let failures = [];
    let email = document.getElementById('input-email');
    let feedbackText = document.getElementById('feedbackText');

    if(email.value === ""){
        failures.push({input: 'input-email', msg: 'no email address submitted'});
    }

    if(feedbackText.value === ""){
        failures.push({input: 'feedbackText', msg:'no text in the text area'});
    }

    return failures;
}
