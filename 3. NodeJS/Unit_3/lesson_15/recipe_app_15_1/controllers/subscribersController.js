"use strict";

// 15.1 Creating a controller for subscribers
const Subscriber = require("../models/subscriber");

exports.getAllSubscribers = (req, res, next) => {
  Subscriber.find({})
    .then((result) => {
      req.data = result;
      next();
    })
    .catch((error) => {
      next(error);

    })
};


// Callbacks no longer work in new versions of mongoose use promises or async and await
/*Subscriber.find({}, (error, subscribers) => {
  if (error) next(error);
  req.data = subscribers;
  next();
});*/