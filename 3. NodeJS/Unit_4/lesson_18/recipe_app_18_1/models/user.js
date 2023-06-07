"use strict";

// 18.1) Creating a User model
const mongoose = require("mongoose"),
  { Schema } = mongoose,
  userSchema = new Schema({  // Creating the user schema
    name: {
      first: {
        type: String,
        trim: true
      },
      last: {
        type: String,
        trim: true
      }
    },
    email: {
      type: String,
      required: true,
      lowercase: true,
      unique: true
    },
    zipCode: {
      type: Number,
      min: [1000, "Zip code too short"],
      max: 99999
    },
    password: {
      type: String,
      required: true
    },
    courses: [{ type: Schema.Types.ObjectId, ref: "Course" }], // Adding the courses property to connect the users to courses
    subscribedAccount: {
      type: Schema.Types.ObjectId,
      ref: "Subscriber"
    }
  },
    {
      timestamps: true
    }
  );

userSchema.virtual("fullName").get(function () { 
  return `${this.name.first} ${this.name.last}`;
});
module.exports = mongoose.model("User", userSchema);
