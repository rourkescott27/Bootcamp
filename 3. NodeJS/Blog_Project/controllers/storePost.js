"use strict";

const blogPost = require('../models/blogPost.js');
const path = require('path');

module.exports = (req, res) => {
    let image = req.files.image;
    image.mv(path.resolve(__dirname, '../public/assets/img', image.name))
        .then(
            blog => {
                blogPost.create({
                    ...req.body,
                    image: 'assets/img/' + image.name,
                    userid: req.session.userId
                })
                    .then(() => {
                        console.log('Post successful')
                        res.redirect('/');
                    })
                    .catch(error => {
                        const validationErrors = Object.keys(error.errors).map(key =>
                            error.errors[key].message)
                        // console.log('THE INSIDE catch block ***************************')
                        // console.log(validationErrors);
                        // console.log(req.body);
                        req.flash('validationErrors', validationErrors)
                        req.flash('data', req.body)
                        res.redirect('/posts/new')
                    })
            })
        .catch(error => {
            console.log('The main catch block ################')
        })
}
