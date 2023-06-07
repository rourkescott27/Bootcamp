"use strict";

const router = require("express").Router(),
    homeController = require("../controllers/homeController");

router.get("/", (req, res) => {
    res.render("index");
});

module.exports = router;