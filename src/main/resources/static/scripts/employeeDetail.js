document.addEventListener("DOMContentLoaded", function(event) {
	// TODO: Anything you want to do when the page is loaded?
});

function validateForm() {
    // TODO: Validate the user input
    var first =  document.getElementById('fName').value;
    var last =  document.getElementById('lName').value;
    var pass =  document.getElementById('password').value;
    var confPass =  document.getElementById('confirmPassword').value;
    var type =  document.getElementById('empType').value;
    
    if(pass != confPass) {
        document.getElementById('error1').innerHTML = "Your passwords did not match";
        return false;
    }

    var str = "INSERT INTO employee";

	return true;
}