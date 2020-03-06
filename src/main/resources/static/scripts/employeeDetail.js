document.addEventListener("DOMContentLoaded", function(event) {
	getSaveActionElement().addEventListener("click", saveActionClick);
});

function validateForm() {
    // TODO: Validate the user input and cleanup
    var first =  getfName();
    var last =  getlName();
    var pass =  getPassword();
    var confPass =  getConfPass();
    var type =  getEmpType();
    
    if (first == null){
        displayError("First name cannot be blank.");
        return false;
    }
    if (last == null){
        displayError("Last name cannot be blank.");
        return false;
    }
    if (pass == null){
        displayError("Password cannot be blank.");
        return false;
    }

    if(pass != confPass) {
        document.getElementById('error1').innerHTML = "Your passwords did not match";
        return false;
    }

    if (type != 'Cashier' && type != 'Shift Manager' && type != 'General Manager') {
        displayError("Employee Type not valid.")
        return false;
    }

    if(ajaxGet())

	return true;
}


function saveActionClick(event) {
	if (!validateSave()) {
		return;
	}

	const saveActionElement = event.target;
	saveActionElement.disabled = true;

	const firstName = getfName();
	const firstNameIsDefined = ((firstName != null) && (firstName.trim() !== ""));
	const saveActionUrl = ("/api/employee/"
		+ (firstNameIsDefined ? firstName : ""));     //What is the url to save
	const saveEmployeetRequest = {
		fname: firstName,
		lname: getlName(),
		password: getPassword(),
		empType: getEmpType()
	};

	if (firstNameIsDefined) {
		ajaxPut(saveActionUrl, saveEmployeetRequest, (callbackResponse) => {
			saveActionElement.disabled = false;

			if (isSuccessResponse(callbackResponse)) {
				displayEmployeeID();
			}
		});
	} else {
		ajaxPost(saveActionUrl, saveEmployeetRequest, (callbackResponse) => {
			saveActionElement.disabled = false;

			if (isSuccessResponse(callbackResponse)) {
				displayEmployeeID();

				if ((callbackResponse.data != null)
					&& (callbackResponse.data.id != null)
					&& (callbackResponse.data.id.trim() !== "")) {

					document.getElementById("empRecordID").classList.remove("hidden");

					setfName(callbackResponse.data.fName.trim());
					setlName(callbackResponse.data.lName.trim());
					setPassword(callbackResponse.data.password.trim());
					setEmpType(callbackResponse.data.empType.trim());
				}
			}
		});
	}
};

function displayEmployeeID() {
	const empIdElement = getEmpRecordID();
	empIdElement.style.display = "none";
	empIdElement.style.display = "block";
}
// End save

// Getters and setters
function getEmpRecordID() {
	return document.getElementById("empRecordID");
}

function getfName() {
	return document.getElementById("fName");
}
function setfName(fName) {
	getfName().value = fName;
}//First Name

function getlName() {
	return document.getElementById("lName");
}
function setlName(lName) {
	getlName().value = lName;
}//Last Name

function getPassword() {
	return document.getElementById("password");
}
function setPassword(password) {
	getPassword().value = password;
}//Password

function getConfPassword() {
	return document.getElementById("confirmPassword");
}
function setConfPassword(confirmPassword){
	getConfPassword().value = confirmPassword;
}//Confirm Password

function getEmpType() {
    return document.getElementById("empType");
}
function setEmpType(empType) {
	getEmpType().value = empType;
}//Employee Type

// End getters and setters