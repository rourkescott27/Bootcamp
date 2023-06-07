"use strict";

// Requiring all neccesary modules and controllers etc.
const express = require("express"),
  app = express(),
  errorController = require("./controllers/errorController"),
  homeController = require("./controllers/homeController"),
  layouts = require("express-ejs-layouts"),
  MongoDB = require("mongodb").MongoClient, //13.5)
  dbURL = "mongodb://127.0.0.1:27017",
  dbName = "recipe_db";

// Connecting to the local database server
MongoDB.connect(dbURL, (error, client) => {
  if (error) throw error;
  // Getting the "recipe_db" database from the connection to the MongoDB server
  let db = client.db(dbName);
  // Finding all contacts and returing them in an array and logging to the console
  db.collection("contacts")
    .find()
    .toArray((error, data) => {
      if (error) throw error;
      console.log(data);
    });

// 13.6) Inserting new contacts to the database
  db.collection("contacts").insert(
    {
      name: "Freddie Mercury",
      email: "fred@queen.com"
    },
    (error, db) => {
      if (error) throw error;
      console.log(db);
    }
  );
}
);

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
