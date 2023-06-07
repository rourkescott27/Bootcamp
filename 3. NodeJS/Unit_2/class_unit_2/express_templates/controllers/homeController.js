"use strict";
//10.2)
// This will respond with a EJS view
/*exports.respondWithName = (req, res) => {
    res.render("index");
};*/
//10.3)
exports.respondWithName = (req, res) => {
    //Assinging a local variable to the request paramater
    let paramsName = req.params.myName; 
    // Here the local variable is passed to a rendered view
    res.render("index", { name: paramsName });
};