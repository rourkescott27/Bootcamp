"use strict";

const User = require("../models/user"),
  Subscriber = require("../models/subscriber"),
  // 22.3) Wrapping user params in the function
  // The getUserParams action modifies the way we handle errors instead of 
  // passing the error to the error-handler action it sets the flash message,
  // and allows the redirectView action to display the user's new.ejs page again.
  getUserParams = body => {
    return {
      name: {
        first: body.first,
        last: body.last
      },
      email: body.email,
      password: body.password,
      zipCode: body.zipCode
    };
  };

function isSubscriber() {
  Subscriber.findById
}

module.exports = {
  index: (req, res, next) => {
    User.find()
      .then(users => {
        res.locals.users = users;
        next();
      })
      .catch(error => {
        console.log(`Error fetching users: ${error.message}`);
        next(error);
      });
  },
  indexView: (req, res) => {
    // 22.6)
      res.render("users/index", {
        flashMessages: {
          success: "Loaded all users!"
        }
      });
    //res.render("users/index");
  },
  new: (req, res) => {
    res.render("users/new");
  },
  // 22.4) Adding flash messages to the create action
  create: (req, res, next) => {
    let userParams = getUserParams(req.body);
    User.create(userParams)
      .then(user => {
        // Response to the user for successful creation
        req.flash("success", `${user.fullName}'s account created successfully!`);
        res.locals.redirect = "/users";
        res.locals.user = user;
        next();
      })
      .catch(error => {
        console.log(`Error saving user: ${error.message}`);
        res.locals.redirect = "/users/new";
        // Response to the user if creation is unsuccessful
        req.flash("error", `Failed to create user account because: ${error.message}.`);
        next();
      });
  },
  redirectView: (req, res, next) => {
    let redirectPath = res.locals.redirect;
    if (redirectPath) res.redirect(redirectPath);
    else next();
  },
  show: (req, res, next) => {
    let userId = req.params.id;
    User.findById(userId)
      .then(user => {
        res.locals.user = user;
        next();
      })
      .catch(error => {
        console.log(`Error fetching user by ID: ${error.message}`);
        ///////////////
        req.flash("error", `Failed to fetch user account because: ${error.message}.`);
        next(error);
      });
  },
  showView: (req, res) => {
    res.render("users/show");
  },
  edit: (req, res, next) => {
    let userId = req.params.id;
    User.findById(userId)
      .then(user => {
        res.render("users/edit", {
          user: user
        });
      })
      .catch(error => {
        console.log(`Error fetching user by ID: ${error.message}`);
        ///////////
        req.flash("error", `Failed to fetch user account because: ${error.message}.`);
        next(error);
      });
  },
  update: (req, res, next) => {
    let userId = req.params.id,
      userParams = {
        name: {
          first: req.body.first,
          last: req.body.last
        },
        email: req.body.email,
        password: req.body.password,
        zipCode: req.body.zipCode
      };
    User.findByIdAndUpdate(userId, {
      $set: userParams
    })
      .then(user => {
        res.locals.redirect = `/users/${userId}`;
        res.locals.user = user;
        //////////
        req.flash("success", `${user.fullName}'s account successfully updated!`);
        next();
      })
      .catch(error => {
        console.log(`Error updating user by ID: ${error.message}`);
        //////////////
        req.flash("error", `Failed to edit user account because: ${error.message}.`);
        next(error);
      });
  },
  delete: (req, res, next) => {
    let userId = req.params.id;
    User.findByIdAndRemove(userId)
      .then(deletedUser => {
        res.locals.redirect = "/users";
        req.flash("success", `${deletedUser.fullName}'s account successfully deleted.`);
        next();
      })
      .catch(error => {
        console.log(`Error deleting user by ID: ${error.message}`);
        ////////////////////
        req.flash("error", `Failed to delete user account because: ${error.message}.`);
        next();
      });
  }
};

