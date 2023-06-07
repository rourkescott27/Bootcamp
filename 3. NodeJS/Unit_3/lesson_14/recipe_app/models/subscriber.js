"use strict";

// 14.3) Defines the structure and property of the document
const mongoose = require("mongoose"),
  subscriberSchema = mongoose.Schema({
    name: String,
    email: String,
    zipCode: Number
  });

// Exporting the module 
module.exports = mongoose.model("Subscriber", subscriberSchema);
