"use strict";

const blogPost = require('../models/blogPost.js');

// Retrieves a blogpost with a specific "id" and passes the blogpost variable to post.ejs
module.exports = async (req, res) => {
    const blogpost = await blogPost.findById(req.params.id).populate('userid');
    console.log(blogpost)
    res.render('post', {
        blogpost
    });
}