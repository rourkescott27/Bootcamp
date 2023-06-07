const port = 3000,
    express = require("express"),
    app = express(),
    homeController = require("./controllers/homeController");
//9.1)
// Requesting to the server to accept the data enclosed in the body of the "post()"
/*app.post("/contact", (req, res) => {
    res.send("Contact information submitted successfully.");
});*/
//9.4)
// Defining the Middleware and logging the request path
/*app.use("/", (req, res, next) => {
    console.log(`request made to => ${req.url}`);
    next(); // Calling the next Middleware function(you must call the next() function otherwise the request will be left hanging)
});*/
//9.2)
// Responding with the path parameters(GET is used to request data from a specified resource)
/*app.get("/items/:vegetable", (req, res) => {
    res.send(req.params.vegetable);
})*/
//9.5)
/*app.use(
    express.urlencoded({
        extended: false
    })
);
// Telling the application to parse the URL encoded data
app.use(express.json());
// Creating a new post route for the home page 
app.post("/", (req, res) => {
    console.log(req.body);
    console.log(req.query);
    console.log(req.params);
    res.send("POST Successful!");
});*/
//9.7)
// This will handle the get requests to the specified route
app.get("/items/:vegetable", homeController.sendReqParam);
app.listen(port, () => {
    console.log(`Server running on port: ${port}`);
});