"use strict";
const express = require("express"),
    app = express(),
    homeController = require("./controllers/homeController"),
    layouts = require("express-ejs-layouts");
app.set("port", process.env.PORT || 3000);
app.set("view engine", "ejs");
app.use(layouts);
app.get("/name/:myName", homeController.respondWithName)
    .listen(app.get("port"), () => {
        console.log(`The Express.js server has started and is listening on port number: ${app.get("port")}`);
    });

