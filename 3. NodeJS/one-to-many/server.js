"use strict";

const mongoose = require("mongoose");
const db = require("./models");

const createTutorial = function (tutorial) {
    return db.Tutorial.create(tutorial).then(docTutorial => {
        console.log(`\n>> Created Tutorial:\n ${docTutorial}`);
        return docTutorial;
    });
};

const createImage = function (tutorialId, image) {
    return db.Image.create(image).then(docImage => {
        console.log(`\n>> Created Image:\n ${docImage}`);
        return db.Tutorial.findByIdAndUpdate(
            tutorialId,
            {
                $push: {
                    images: {
                        _id: docImage._id,
                        url: docImage.url,
                        caption: docImage.caption
                    }
                }
            },
            { new: true, useFindAndModify: false }
        );
    });

};

const createComment = function (tutorialId, comment) {
    return db.Comment.create(comment).then(docComment => {
        console.log(`\n>> Created Comment:\n ${docComment}`);

        return db.Tutorial.findByIdAndUpdate(
            tutorialId,
            { $push: { comments: docComment._id } },
            { new: true, useFindAndModify: false }
        );
    });
};

const getTutorialWithPopulate = function (id) {
    return db.Tutorial.findById(id).populate("comments", "-_id -__v");
};

const createCategory = function (category) {
    return db.Category.create(category).then(docCategory => {
        console.log(`\n>> Created Category:\n ${docCategory}`);
        return docCategory;
    });
};

const addTutorialToCategory = function (tutorialId, categoryId) {
    return db.Tutorial.findByIdAndUpdate(
        tutorialId,
        { category: categoryId },
        { new: true, useFindAndModify: false }
    );
};

const getTutorialsInCategory = function (categoryId) {
    return db.Tutorial.find({ category: categoryId })
        .populate("category", "name -_id")
        .select("-comments -images -__v");
};

const run = async function () {
    //******Creating Tutorial******/
    var tutorial = await createTutorial({
        title: "Tutorial #1",
        author: "Rourke"
    });

    //******Creating Category******/
    var category = await createCategory({
        name: "Node.js",
        description: "Node.js tutorial"
    });

    //******Adding Tutorial to Category******/
    await addTutorialToCategory(tutorial._id, category._id);

    var newTutorial = await createTutorial({
        title: "Tutorial #2",
        author: "Rourke"
    });

    await addTutorialToCategory(newTutorial._id, category._id);

    var tutorials = await getTutorialsInCategory(category._id);
    console.log(`\n>> All Tutorials in Category:\n ${tutorials}`)

    //******Creating Images******/
    tutorial = await createImage(tutorial._id, {
        path: "sites/uploads/images/mongodb.png",
        url: "/images/mongodb.png",
        caption: "MongoDB Database",
        createdAt: Date.now()
    });
    console.log(`\n>> Tutorial:\n ${tutorial}`);

    tutorial = await createImage(tutorial._id, {
        path: "sites/uploads/images/one-to-many.png",
        url: "/images/one-to-many.png",
        caption: "One to Many Relationship",
        createdAt: Date.now()
    });
    console.log(`\n>> Tutorial:\n ${tutorial}`);

    //******Creating Comments******/
    tutorial = await createComment(tutorial._id, {
        username: "Jack",
        text: "This is a great tutorial.",
        createdAt: Date.now()
    });
    console.log(`\n>> Tutorial:\n ${tutorial}`);

    tutorial = await createComment(tutorial._id, {
        username: "Mary",
        text: "Thank you it helps me alot.",
        createdAt: Date.now()
    });
    console.log(`\n>> Tutorial:\n ${tutorial}`);

    tutorial = await getTutorialWithPopulate(tutorial._id);
    console.log(`\n>> Populated Tutorial:\ ${tutorial}`);

    tutorial = await addTutorialToCategory(tutorial._id, category._id);
    console.log(`\n>> Tutorial":\n ${tutorial}`);


};

mongoose
    .connect("mongodb://127.0.0.1/bezkoder_db", {
        useNewUrlParser: true,
        useUnifiedTopology: true
    })
    .then(() => console.log("Successfully connected to MongoDB."))
    .catch(err => console.error(`Connection Error ${err}`));

run();