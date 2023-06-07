"use strict";

// 17.1) Defining the subscriber schema
const mongoose = require("mongoose");
// 17.2) Adding validators to the subscriber schema
const subscriberSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true
  },
  email: {
    type: String,
    required: true,
    lowercase: true,
    unique: true
  },
  zipCode: {
    type: Number,
    min: [10000, "Zip code too short"],
    max: 99999
  },
  courses: [{ type: mongoose.Schema.Types.ObjectId, ref: "Course" }]
});

// 17.3) Adding instance methods to the schema
subscriberSchema.methods.getInfo = function() {  // Adding an instance method to get the full name of a subscriber.
  return `Name: ${this.name} Email: ${this.email} Zip Code: ${this.zipCode}`;
};

// Adding an instance method to find subscribers with the same ZIP code.
subscriberSchema.methods.findLocalSubscribers = function() {
  return this.model("Subscriber")
    .find({ zipCode: this.zipCode })
    .exec(); // Access the Subscriber model to use the find method.
};

module.exports = mongoose.model("Subscriber", subscriberSchema);
