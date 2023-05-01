//8.1)
"use strict";
const port = 3000,
    express = require("express"),
    app = express();

app.post("/", (req, res) => {
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