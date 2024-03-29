"use strict";

// 26.2) Importing all routes
const router = require("express").Router(),
    userRoutes = require("./userRoutes"),
    subscriberRoutes = require("./subscriberRoutes"),
    courseRoutes = require("./courseRoutes"),
    errorRoutes = require("./errorRoutes"),
    homeRoutes = require("./homeRoutes");

// Order matters. Make sure to have the more-detailed routes closer to the top of index.js
// Express.js router operates through middleware. Using it you can define the 
// tasks you want it to perform on.

// Namespaces?
router.use("/users", userRoutes);
router.use("/subscribers", subscriberRoutes);
router.use("/courses", courseRoutes);
router.use("/", homeRoutes);
router.use("/", errorRoutes);

module.exports = router;