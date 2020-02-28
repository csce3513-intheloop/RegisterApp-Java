

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

//!!TODO-Should be defined in a common module that can be accessed 
//from each of the client-side modules (a view/script(s)/style(s) triplet)



