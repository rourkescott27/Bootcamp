/*In lesson 14 =>
Installing and connecting Mongoose to your Node.js application
Creating a schema
Building and instantiating Mongoose data models
Loading and saving data with custom methods*/

"use strict";

const express = require("express"),
  app = express(),
  errorController = require("./controllers/errorController"),
  homeController = require("./controllers/homeController"),
  layouts = require("express-ejs-layouts"),
  mongoose = require("mongoose"),
  Subscriber = require("./models/subscriber");

// 14.1)Setting up connection to the database
mongoose.connect(
  "mongodb://127.0.0.1:27017/recipe_db",
  { useNewUrlParser: true }
);

// Assigning the database to the db variable
const db = mongoose.connection;

// 14.2)
db.once("open", () => {
  console.log("Successfully connected to MongoDB using Mongoose!");
});

// 14.6) Query does not work 
/*var myQuery = Subscriber.findOne({
  name: "Jon Wexler"
}).where("email", /wexler/);

myQuery.exec((error, data) => {
  if (data) console.log(data.name);
});*/

// Specifying what port to listen to 
app.set("port", process.env.PORT || 3000);
// Preparing the application for rendering EJS templates
app.set("view engine", "ejs");

// Build-in middleware
app.use(express.static("public"));
app.use(layouts);
app.use(
  express.urlencoded({
    extended: false
  })
);
app.use(express.json());
app.use(homeController.logRequestPaths);

// Routing
app.get("/name", homeController.respondWithName);
app.get("/items/:vegetable", homeController.sendReqParam);

app.post("/", (req, res) => {
  console.log(req.body);
  console.log(req.query);
  res.send("POST Successful!");
});

// Error-handling middleware
app.use(errorController.logErrors);
app.use(errorController.respondNoResourceFound);
app.use(errorController.respondInternalError);

app.listen(app.get("port"), () => {
  console.log(`Server running at http://localhost:${app.get("port")}`);
});
