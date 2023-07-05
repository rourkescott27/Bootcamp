"use strict";

module.exports = (req, res) => {
    var title = ""
    var description = ""
    const data = req.flash('data')[0];

    if (typeof data != "undefined") {
        title = data.title
        description = data.body
    }
    // console.log("title*********", title, description);
    // console.log("data==>", req.flash('data'));
    // console.log("req.flash.validationErrors", req.flash('validationErrors'));
    res.render('create', {
        errors: req.flash('validationErrors'), // Retrieves errors from the session
        title,
        createPost: true
    })
}