//Mix of Lesson 10 and 11 (express_templates)
"use strict";
const express = require("express"),
    app = express(),
    homeController = require("./controllers/homeController"),
    errorController = require("./controllers/errorController"),
    layouts = require("express-ejs-layouts");

app.set("port", process.env.PORT || 3000);
// Preparing the application for rendering EJS templates
app.set("view engine", "ejs");
app.use(layouts);

// Calling the respond with name function from the homeController
app.get("/name/:myName", homeController.respondWithName);

app.use(express.static("public"));
// Added error handling middleware
app.use(errorController.respondNoResourceFound);
app.use(errorController.respondInternalError);

app.listen(app.get("port"), () => {
    console.log(`The Express.js server has started and is listening on port number: ${app.get("port")}`);
});

