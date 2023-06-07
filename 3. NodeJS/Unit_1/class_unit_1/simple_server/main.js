"use strict";
/* .1. Assinging a port number 3000.
   .2. The "http" constant is requiring to import the Node.js "http" module.
   .3. Then require the "http-status-codes" package and save it to "httpStatus".
   .4. Using the http constant as reference to create a server and storing it
       in the variable "app".*/

const port = 3000,
  http = require("http"),
  httpStatus = require("http-status-codes"),
  app = http.createServer((request, response) => {
    console.log('Received an incoming request!');
    // This is the response to the client
    response.writeHead(httpStatus.OK, {
      'Content-Type': 'text/html'
    });
    // Creating the response to the client
    let responseMessage = '<h1>Hello, Universe<h1>';
    response.write(responseMessage);
    response.end();
    console.log(`Sent a response : ${responseMessage}`);
  });

// Creating a listener on the specified port 
app.listen(port);
console.log(`The server has started and is listening on port number: ${port}`);
