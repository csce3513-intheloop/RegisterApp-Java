document.addEventListener("DOMContentLoaded", function(event) {
	// TODO: Anything you want to do when the page is loaded?
	document.getElementById("signIn").addEventListener("click", validateForm);
});

function validateForm() {
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
}
