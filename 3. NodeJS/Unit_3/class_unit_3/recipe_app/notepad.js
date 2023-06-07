// Code used to search subscribers in the REPL and to see errors and duplicates
const mongoose = require("mongoose"),
    Subscriber = require("./models/subscriber");
mongoose.connect(
    "mongodb://127.0.0.1:27017/recipe_db",
    { useNewUrlParser: true }
);
mongoose.Promise = global.Promise;
/////////////////////////////////////////////////////////

/*Subscriber.create({
    name: "Sheryl",
    email: "sheryl@gmail.com",
    zipCode: 11000
})
    .then((result) => {
        console.log("result");
        console.log(result);
    })
    .catch((err) => {
        console.log("err");
        console.log(err);
    })
/////////////////////////////////////////////////////////

Subscriber.create({
    name: "Jon",
    email: "jonWexler@gmail.com",
    zipCode: "11000"
})
    .then(subscriber => console.log(subscriber))
    .catch(error => console.log(error.message));
////////////////////////////////////////////////////////

var subscriber;
Subscriber.findOne({
    zipCode: "11000"
})
    .then(result => {
        subscriber = result;
        console.log(subscriber.getInfo());
    });
///////////////////////////////////////////////////////
var subscriber;
Subscriber.findOne({
    name: "Sheryl"
})
    .then(result => {
        subscriber = result;
        console.log(subscriber.findLocalSubscribers());
    });
//////////////////////////////////////////////////////
Subscriber.findOne({
    name: "Sheryl",
    email: "sheryl@gmail.com",
    zipCode: 11000
})
    .then((result) => {
        result.findLocalSubscribers()
            .then((result) => {
                console.log("result");
                console.log(result);
            })

    })
    .catch((err) => {
        console.log("err");
        console.log(err);
    })
//////////////////////////////////////////////////////
// Listing 17.7 Testing model associations using REPL in terminal
const Course = require("./models/course");
let testCourse, testSubscriber;
Course.create({
    title: "Tomato Land",
    description: "Locally farmed tomatoes only",
    zipCode: 12345,
    items: ["cherry", "heirloom"]
}).then(course => testCourse = course);
Subscriber.findOne({}).then(
    subscriber => testSubscriber = subscriber
);
//----------------------------------------------\\
testSubscriber.courses.push(testCourse._id);
testSubscriber.save();
Subscriber.populate(testSubscriber, "courses").then(subscriber =>
    console.log(subscriber)
);*/
////////////////////////////////////////////////////
Subscriber.find({ courses: new mongoose.Types.ObjectId("645388a3527ece07b89d42cc") })
/////////////////////////////////////////////////////
const mongoose = require("mongoose"),
    Subscriber = require("./models/subscriber"),
    Course = require("./models/course");
var testCourse,
    testSubscriber;
mongoose.connect(
    "mongodb://127.0.0.1:27017/recipe_db",
    { useNewUrlParser: true }
);
mongoose.Promise = global.Promise;
Subscriber.deleteMany({})
    .then((items) => console.log(`Removed ${items.n} records!`))
    .then(() => {
        return Course.deleteMany({});
    })
    .then((items) => console.log(`Removed ${items.n} records!`))
    .then(() => {
        return Subscriber.create({
            name: "Jon",
            email: "jon@jonwexler.com",
            zipCode: "12345"
        });
    })
    .then(subscriber => {
        console.log(`Created Subscriber: ${subscriber.getInfo()}`);
    })
    .then(() => {
        return Subscriber.findOne({
            name: "Jon"
        });
    })
    .then(subscriber => {
        testSubscriber = subscriber; console.log(`Found one subscriber: ${subscriber.getInfo()}`);
    })
    .then(() => {
        return Course.create({
            title: "Tomato Land",
            description: "Locally farmed tomatoes only",
            zipCode: 12345,
            items: ["cherry", "heirloom"]
        });
    })
    .then(course => {
        testCourse = course;
        console.log(`Created course: ${course.title}`);
    })
    .then(() => {
        testSubscriber.courses.push(testCourse);
        testSubscriber.save();
    })
    .then(() => {
        return Subscriber.populate(testSubscriber, "courses");
    })
    .then(subscriber => console.log(subscriber))
    .then(() => {
        return Subscriber.find({
            courses: new mongoose.Types.ObjectId(testCourse._id)
        })
    })
    .then(subscriber => console.log(subscriber))
    .catch(error => console.log(error));

////////////////////////////////////////////////////////
const User = require("./models/user");
var testUser;
User.create({
    name: {
        first: "Jon",
        last: "Wexler"
    },
    email: "jon@jonwexler.com",
    password: "pass123"
})
    .then(user => testUser = user)
    .catch(error => console.log(error.message));

User.findOne({ email: "jon@jonwexler.com" }).then(u => testUser = u)
    .catch(e => console.log(e.message));

//Listing 18.6 Connecting a subscriber to the user in REPL in terminal
var testUser;
User.create({
    name: {
        first: "Jon",
        last: "Wexler "
    },
    email: "jon@jonwexler.com",
    password: "pass123"
})
    .then(user => {
        testUser = user;
        return Subscriber.findOne({
            email: user.email
        });
    })
    .then(subscriber => {
        testUser.subscribedAccount = subscriber;
        testUser.save().then(user => console.log("user updated"));
    })
    .catch(error => console.log(error.message));
