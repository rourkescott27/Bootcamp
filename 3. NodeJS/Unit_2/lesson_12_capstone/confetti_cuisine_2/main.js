"use strict";
// Setting up the main application logic in main.js
const express = require("express"),
    app = express(),
    homeController = require("./controllers/homeController"),
    errorController = require("./controllers/errorController"),
    // Enable EJS layout rendering in main.js
    layouts = require("express-ejs-layouts");
app.set("view engine", "ejs");
app.set("port", process.env.PORT || 3000);
// Adding body parsing to the top of main.js
app.use(
    express.urlencoded({
        extended: false
    })
);
app.use(express.json());
app.use(layouts);
// Serving static views
app.use(express.static("public"))

app.get("/", (req, res) => {
    res.render("index");
});

// Adding routes for each page and request type in main.js
app.get("/courses", homeController.showCourses);
app.get("/contact", homeController.showSignUp);
app.post("/contact", homeController.postedSignUpForm);

// Adding error handling routes in main.js
app.use(errorController.pageNotFoundError);
app.use(errorController.internalServerError);

app.listen(app.get("port"), () => {
    console.log(
        `Server running at http://localhost:${app.get("port")}`
    );
});