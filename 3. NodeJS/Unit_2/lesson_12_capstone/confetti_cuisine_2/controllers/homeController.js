"use strict";
// Set up content on server and pass into rendered view in homeController.js
var courses = [
    {
        title: "Event Driven Cakes",
        cost: 50
    },
    {
        title: "Asynchronous Artichoke",
        cost: 25
    },
    {
        title: "Object Oriented Orange Juice",
        cost: 10
    }
];

// Adding route actions to my home controller in homeController.js
exports.showCourses = (req, res) => {
    res.render("courses", {
        offeredCourses: courses
    });
};

exports.showSignUp = (req, res) => {
    res.render("contact");
};

exports.postedSignUpForm = (req, res) => {
    res.render("thanks");
};

