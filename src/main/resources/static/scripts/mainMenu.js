document.addEventListener("DOMContentLoaded", () => {
    var errorMessage = "Functionality has not yet been implemented.";
    document.getElementById("startTxn").addEventListener("click", function()
    { displayError(errorMessage);});
    
    document.getElementById("salesReport").addEventListener("click", function()
    { displayError(errorMessage);});
    
    document.getElementById("cashierReport").addEventListener("click", function()
    { displayError(errorMessage);});
    
    document.getElementById("signOut").addEventListener("click", signOutActionClickHandler());
});





