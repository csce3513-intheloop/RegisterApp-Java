document.addEventListener("DOMContentLoaded", function(event) {
	// TODO: Anything you want to do when the page is loaded?
});

function validateForm() {

	var empId =  getEmpId();
    var pass =  getPassword();
	
	if(empId == '' && pass == '') {
		document.getElementById("msg").innerHTML = "Please help! im dying!";
		return false;
	} else {
		document.getElementById("msg").innerHTML = "u suck!";
		return true;
	}
}

function getPassword() {
	return document.getElementById("password");
}//Confirm Password

function getEmpId() {
    return document.getElementById("employeeId");
}   //Employee Type
