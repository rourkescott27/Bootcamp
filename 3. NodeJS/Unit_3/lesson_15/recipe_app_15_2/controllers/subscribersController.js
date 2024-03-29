"use strict";

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

// 15.6 Controller actions for subscription routes in subscribersController.js
exports.getSubscriptionPage = (req, res) => {
  res.render("contact");
};

exports.saveSubscriber = (req, res) => {
  let newSubscriber = new Subscriber({
    name: req.body.name,
    email: req.body.email,
    zipCode: req.body.zipCode
  });

  newSubscriber.save()
    .then((result) => {
      res.render("Thanks");
    })
    .catch((error) => {
      res.send(error);
    })

};
