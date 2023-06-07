"use strict";

// Logs the request path 
exports.logRequestPaths = (req, res, next) => {
  console.log(`Request made to: => ${req.url}`);
  next();
};

// Displayed to the client when "/items/:vegetable" is input into the URL
exports.sendReqParam = (req, res) => {
  let veg = req.params.vegetable;
  res.send(`This is the page for ${veg}`);
};

// Renders the index.ejs 
exports.respondWithName = (req, res) => {
  res.render("index");
};
