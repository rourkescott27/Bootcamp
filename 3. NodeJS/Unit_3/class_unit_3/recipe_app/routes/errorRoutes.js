"use strict";
const express = require("express"),
    app = express(),
    errorController = require("./controllers/errorController");

// Error handling
app.use(errorController.logErrors);
app.use(errorController.respondNoResourceFound);
app.use(errorController.respondInternalError);