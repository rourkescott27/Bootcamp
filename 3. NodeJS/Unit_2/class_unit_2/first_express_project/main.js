//Lesson 8
//8.1)
"use strict";
const port = 3000,
// Adding the express module and then assinging it to the app constant
    express = require("express"),
    app = express();

/*Setting up a GET route for access to the home page and then issuing a 
response to the client from the server, which is accomplised using the 
"send() method"*/
app.get("/", (req, res) => {
    //8.2)
    console.log("Params => " + req.params);
    console.log("Body => " + req.body);
    console.log("URL => " + req.url);
    console.log("Query => " + req.query);
    res.send("Hello Universe!");
})
app.listen(port, () => {
    console.log(`The Express.js server has started and is listening ➥ on port number: ${port}`);
});