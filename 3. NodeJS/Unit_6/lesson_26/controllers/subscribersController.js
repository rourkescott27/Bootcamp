// Removed previous subscribersController code
"use strict";

const Subscriber = require("../models/subscriber"),
    getSubscriberParams = (body) => {
        return {
            name: body.name,
            email: body.email,
            zipCode: parseInt(body.zipCode)
        };
    };

module.exports = {
    index: (req, res, next) => {
        Subscriber.find()
            .then(subscribers => {
                res.locals.subscribers = subscribers;
                next();
            })
            .catch(error => {
                console.log(`Error fetching subscribers: ${error.message}`);
                next(error);
            });
    },
    //Responding with JSON when query param exists
    indexView: (req, res) => {
        if (req.query.format === "json") {
            res.json(res.locals.subscribers);
        } else {
            res.render("subscribers/index");
        }
    },
    new: (req, res) => {
        res.render("subscribers/new");
    },
    create: (req, res, next) => {
        let subscriberParams = getSubscriberParams(req.body);
        console.log("Attempgint to create subscriber.")
        console.log(subscriberParams);
        Subscriber.create(subscriberParams)
            .then(subscriber => {
                res.locals.redirect = "/subscribers";
                res.locals.subscriber = subscriber;
                req.flash("success", `${subscriber.name}'s profile successfully created!`);
                next();
            })
            .catch(error => {
                console.log(`Error saving subscriber:${error.message}`);
                req.flash("error", `Unable to create user's profile: ${error.message}.`);
                next(error);
            });
    },
    redirectView: (req, res, next) => {
        let redirectPath = res.locals.redirect;
        if (redirectPath) res.redirect(redirectPath);
        else next();
    },
    show: (req, res, next) => {
        var subscriberId = req.params.id;
        Subscriber.findById(subscriberId)
            .then(subscriber => {
                res.locals.subscriber = subscriber;
                next();
            })
            .catch(error => {
                console.log(`Error fetching subscriber by ID: ${error.message}`)
                next(error);
            });
    },
    //Responding with JSON when query param exists
    showView: (req, res) => {
        if (req.query.format === "json") {
            res.json(res.locals.subscriber);
        } else {
            res.render("subscribers/show");
        }
    },
    edit: (req, res, next) => {
        var subscriberId = req.params.id;
        Subscriber.findById(subscriberId)
            .then(subscriber => {
                res.render("subscribers/edit", {
                    subscriber: subscriber
                });
            })
            .catch(error => {
                console.log(`Error fetching subscriber by ID:  ${error.message}`);
                next(error);
            });
    },
    update: (req, res, next) => {
        let subscriberId = req.params.id,
            subscriberParams = getSubscriberParams(req.body);
        Subscriber.findByIdAndUpdate(subscriberId, {
            $set: subscriberParams
        })
            .then(subscriber => {
                res.locals.redirect = `/subscribers/${subscriberId}`;
                res.locals.subscriber = subscriber;
                req.flash("success", `${subscriber.name}'s profile successfully edited!`);
                next();
            })
            .catch(error => {
                req.flash("error", `Unable to edit user's profile: ${error.message}.`);
                next(error);
            });
    },
    delete: (req, res, next) => {
        let subscriberId = req.params.id;
        Subscriber.findByIdAndRemove(subscriberId)
            .then(subscriber => {
                res.locals.redirect = "/subscribers";
                req.flash("success", `${subscriber.name}'s profile successfully deleted!`);
                next();
            })
            .catch(error => {
                console.log(`Error deleting subscriber by ID: ${error.message}`);
                req.flash("error", `Unable to delete user's profile: ${error.message}.`);
                next();
            });
    },
    getSubscriptionPage: (req, res) => {
        res.render("contact");
    },
    saveSubscriber: (req, res) => {
        let newSubscriber = new Subscriber({
            name: req.body.name,
            email: req.body.email,
            zipCode: req.body.zipCode
        });

        newSubscriber.save()
            .then(res.render("thanks"))
            .catch(error => res.send(error))
    }
};
