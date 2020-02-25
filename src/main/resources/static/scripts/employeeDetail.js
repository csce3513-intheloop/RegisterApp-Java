document.addEventListener("DOMContentLoaded", function(event) {
	// TODO: Anything you want to do when the page is loaded?
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

    var str = "INSERT INTO employee";

	return true;
}

// TODO: Save
/*
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
//Above still need check
//Below is unchanged from productDetail
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
// End save

//TODO:
/*After save AND employeeID input = hidden,
    display employeeID input but remain disabled
*/

// Getters and setters
function getfName() {
	return document.getElementById("fName");
}//First Name

function getlName() {
	return document.getElementById("lName");
}//Last Name

function getPassword() {
	return document.getElementById("password");
}//Password

function getConfPassword() {
	return document.getElementById("confirmPassword");
}//Confirm Password

function getEmpType() {
    return document.getElementById("empType");
}   //Employee Type

// End getters and setters