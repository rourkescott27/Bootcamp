"use strict";

// 27.1) Adding a route to show all courses
const router = require("express").Router(),
    subscribersController = require("../controllers/subscribersController"),
    coursesController = require("../controllers/coursesController"),
    usersController = require("../controllers/usersController");

// The index action in coursesController.js already attaches courses to the response’s locals
// object. Take that locals object and displays it in JSON format instead of rendering the data in EJS.
router.get("/courses", coursesController.index, coursesController.filterUserCourses, coursesController.respondJSON);
router.get("/courses/:id/join", coursesController.join, coursesController.respondJSON);

router.get("/subscribers", subscribersController.index, subscribersController.respondJSON);

router.get("/users", usersController.index, usersController.respondJSON);
router.post("/users/new", usersController.validate, usersController.create, usersController.respondJSON);

// API error handling-middleware
router.use(coursesController.errorJSON);

module.exports = router;