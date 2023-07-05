"use strict";

module.exports = (req, res) => {
    let username = ""

    const data = req.flash('data')[0];
    const error = req.flash('error');

    if (typeof data != "undefined") {
        username = data.username
    }

    res.render('login', {
        error,
        username
    })
}
