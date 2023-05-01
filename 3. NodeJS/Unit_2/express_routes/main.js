const port = 3000,
    express = require("express"),
    app = express(),
    homeController = require("./controllers/homeController");
//9.1)
/*app.post("/contact", (req, res) => {
    res.send("Contact information submitted successfully.");
});*/
//9.4)
/*app.use("/", (req, res, next) => {
    console.log(`request made to => ${req.url}`);
    next();
});*/
//9.2)
/*app.get("/items/:vegetable", (req, res) => {
    res.send(req.params.vegetable);
})*/
//9.5)
/*app.use(
    express.urlencoded({
        extended: false
    })
);
app.use(express.json());
app.post("/", (req, res) => {
    console.log(req.body);
    console.log(req.query);
    console.log(req.params);
    res.send("POST Successful!");
});*/
//9.6)
app.get("/items/:vegetable", homeController.sendReqParam);
app.listen(port, () => {
    console.log(`Server running on port: ${port}`);
});