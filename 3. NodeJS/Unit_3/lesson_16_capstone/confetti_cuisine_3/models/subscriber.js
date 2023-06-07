"use strict";

// 16.2) Defining a subscriber schema in subscriber.js
const mongoose = require("mongoose"),
    subscriberSchema = mongoose.Schema({
        name: String,
        email: String,
        zipCode: Number
    });

// 16.3) Creating an exported subscriber model in subscriber.js
module.exports = mongoose.model("Subscriber", subscriberSchema);