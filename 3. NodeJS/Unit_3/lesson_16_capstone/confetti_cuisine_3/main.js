"use strict";
// Setting up the main application logic in main.js
const express = require("express"),
    app = express(),
    homeController = require("./controllers/homeController"),
    errorController = require("./controllers/errorController"),
    subscribersController = require("./controllers/subscribersController"),
    // Enable EJS layout rendering in main.js
    layouts = require("express-ejs-layouts"),
    mongoose = require("mongoose");

// 16.1) Setting up Mongoose in the Node.js application in main.js
mongoose.connect(
    "mongodb://127.0.0.1:27017/confetti_cuisine",
    { useNewUrlParser: true }
);
// Support for promise chains
mongoose.Promise = global.Promise // not in source code??

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

// Routing for subscribersController.js
app.get("/subscribers", subscribersController.getAllSubscribers);
app.get("/contact", subscribersController.getSubscriptionPage);
app.post("/subscribe", subscribersController.saveSubscriber);

// Routing for homeController.js
app.get("/courses", homeController.showCourses);
app.get("/contact", homeController.showSignUp);
app.post("/contact", homeController.postedSignUpForm);

// Error handling middleware
app.use(errorController.pageNotFoundError);
app.use(errorController.internalServerError);

app.listen(app.get("port"), () => {
    console.log(
        `Server running at http://localhost:${app.get("port")}`
    );
});