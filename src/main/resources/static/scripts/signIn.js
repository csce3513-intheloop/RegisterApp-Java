document.addEventListener("DOMContentLoaded", function(event) {
	// TODO: Anything you want to do when the page is loaded?
	document.getElementById("signIn").addEventListener("click", validateForm);
});

function validateForm() {
<<<<<<< HEAD
	var employeeId = document.forms["signIn"]["employeeId"].value;
	var password = document.forms["signIn"]["password"].value;

	if ((employeeId == '') && (password == '')) {
		document.getElementById("msg").innerHTML = "The employee ID  and password fields must not be empty."
		return false;
	} else if (employeeId == "") {
		document.getElementById("msg").innerHTML = "The employee ID field must not be empty.";
		return false;
	} else if (password == "") {
		document.getElementById("msg").innerHTML = "The password field must not be empty.";
		return false;
	}

	return true;
=======

	var empId =  getEmpId();
    var pass =  getPassword();
	
	if(empId == '' && pass == '') {
		document.getElementById("msg").innerHTML = "Please help! im dying!";
		return false;
	} else {
		document.getElementById("msg").innerHTML = "u suck!";
		return true;
	}
>>>>>>> 7c9f57a4cc6623a76852c79d57bd9d8a110a4c83
}

function getPassword() {
	return document.getElementById("password");
}//Confirm Password

function getEmpId() {
    return document.getElementById("employeeId");
}   //Employee Type
