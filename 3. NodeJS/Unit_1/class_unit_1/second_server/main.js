"use strict";
const port = 3000,
    http = require("http"), // Requiring "http" module
    httpStatus = require("http-status-codes"), // Requiring "http-status-codes" package
    app = http.createServer(); /* Creating a server by referencing the "http" varaible
                                and saving it to the app variable*/

app.on("request", (req, res) => { // Listening for requests to the server
    const getJSONString = obj => {
        return JSON.stringify(obj, null, 2);
    };
    var body = [];
    req.on("data", (bodyData) => {
        body.push(bodyData);
    });
    req.on("end", () => {
        body = Buffer.concat(body).toString();
        console.log(`Request Body Contents: ${body}`);
    });
    console.log(`==> Method: ${getJSONString(req.method)}`);
    console.log(`==> URL: ${getJSONString(req.url)}`);
    console.log(`==> Headers: ${getJSONString(req.headers)}`);

    // Preparing the HTML response that the client will see
    res.writeHead(httpStatus.OK, {
        "Content-Type": "text/html"
    });
    let responseMessage = "<h1>This will show on the screen.</h1>";
    res.end(responseMessage);
});
app.listen(port);
console.log(`The server has started and is listening on port number: ➥ ${port}`);


/*app.on("request", (req, res) => {
const getJSONString = obj => {
    return JSON.stringify(obj, null, 2);
};
console.log(`**Method**: ${getJSONString(req.method)}`);
console.log(`**URL**: ${getJSONString(req.url)}`);
console.log(`**Headers**: ${getJSONString(req.headers)}`);
res.writeHead(httpStatus.OK, {
    "Content-Type": "text/html"
});
let responseMessage = "<h1>This will show on the screen.</h1>";
res.end(responseMessage);
});
app.listen(port);
console.log(`The server has started and is listening on port number: ➥ ${port}`);*/