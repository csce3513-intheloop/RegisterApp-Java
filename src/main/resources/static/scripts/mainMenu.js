

document.addEventListener("DOMContentLoaded", () => {
    var errorMessage = "Functionality has not yet been implemented.";
    document.getElementById("startTxn").addEventListener("click", function()
    { displayError(errorMessage);});
    
    document.getElementById("salesReport").addEventListener("click", function()
    { displayError(errorMessage);});
    
    document.getElementById("cashierReport").addEventListener("click", function()
    { displayError(errorMessage);});

    document.getElementById("viewProducts").addEventListener("click", listingClick);

    document.getElementById("empDetails").addEventListener("click", detailClick);

    document.getElementById("signOut").addEventListener("click", signOutActionClickHandler());
});

function listingClick() {
	window.location.assign("/productListing/");
}

function detailClick() {
	window.location.assign("/productDetail/");
}


