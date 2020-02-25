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

    //Check if pass == confPass

    var str = "INSERT INTO employee";

	return true;
}
//TODO: Fix from productDetail to EmployeeDetail
// Save
function saveActionClick(event) {
	if (!validateSave()) {
		return;
	}

	const saveActionElement = event.target;
	saveActionElement.disabled = true;

	const firstName = getfName();
	const firstNameIsDefined = ((firstName != null) && (firstName.trim() !== ""));
	const saveActionUrl = ("/api/product/"
		+ (firstNameIsDefined ? firstName : ""));     //What is the url to save
	const saveProductRequest = {
		fname: firstName,
		lname: getlName(),
		password: getPassword()
	};
/*
	if (firstNameIsDefined) {
		ajaxPut(saveActionUrl, saveProductRequest, (callbackResponse) => {
			saveActionElement.disabled = false;

			if (isSuccessResponse(callbackResponse)) {
				displayProductSavedAlertModal();
			}
		});
	} else {
		ajaxPost(saveActionUrl, saveProductRequest, (callbackResponse) => {
			saveActionElement.disabled = false;

			if (isSuccessResponse(callbackResponse)) {
				displayProductSavedAlertModal();

				if ((callbackResponse.data != null)
					&& (callbackResponse.data.id != null)
					&& (callbackResponse.data.id.trim() !== "")) {

					document.getElementById("deleteActionContainer").classList.remove("hidden");

					setProductId(callbackResponse.data.id.trim());
				}
			}
		});
	}*/
};
/*
function validateSave() {
	const lookupCode = getProductLookupCode();
	if ((lookupCode == null) || (lookupCode.trim() === "")) {
		displayError("Please provide a valid product lookup code.");
		return false;
	}

	const count = getProductCount();
	if ((count == null) || isNaN(count)) {
		displayError("Please provide a valid product count.");
		return false;
	} else if (count < 0) {
		displayError("Product count may not be negative.");
		return false;
	}

	return true;
}

function displayProductSavedAlertModal() {
	if (hideProductSavedAlertTimer) {
		clearTimeout(hideProductSavedAlertTimer);
	}

	const savedAlertModalElement = getSavedAlertModalElement();
	savedAlertModalElement.style.display = "none";
	savedAlertModalElement.style.display = "block";

	hideProductSavedAlertTimer = setTimeout(hideProductSavedAlertModal, 1200);
}

function hideProductSavedAlertModal() {
	if (hideProductSavedAlertTimer) {
		clearTimeout(hideProductSavedAlertTimer);
	}

	getSavedAlertModalElement().style.display = "none";
}*/
// End save

// Getters and setters
function getfName() {
	return getfNameElement().value;
}
function setfName(fName) {
	getfNameElement().value = fName;
}
function getfNameElement() {
	return document.getElementById("fName");
}   //First Name

function getlName() {
	return getlNameElement().value;
}
function setlName(lName) {
	getlNameElement().value = lName;
}
function getlNameElement() {
	return document.getElementById("lName");
}   //Last Name

function getPassword() {
	return getPasswordElement().value;
}
function setPassword(password) {
	getPasswordElement().value = password;
}
function getPasswordElement() {
	return document.getElementById("password");
}   //Password

function getEmpType() {
    return getEmpTypeElement().value;
}
function setEmpType(empType) {
    getEmpType().value = empType;
}
function getEmpTypeElement() {
    return document.getElementById("empType");
}   //Employee Type
// End getters and setters