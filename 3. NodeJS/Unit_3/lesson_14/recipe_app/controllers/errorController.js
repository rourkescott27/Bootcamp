"use strict";

const httpStatus = require("http-status-codes");

// Displays the point in the code at which the error instance occured
exports.logErrors = (error, req, res, next) => {
  console.error(error.stack);
  next(error);
};

// Handles status code 404 errors
exports.respondNoResourceFound = (req, res) => {
  let errorCode = httpStatus.NOT_FOUND;
  res.status(errorCode);
  res.send(`${errorCode} | The page does not exist!`);
};

// Handles status code 500 errors
exports.respondInternalError = (error, req, res, next) => {
  let errorCode = httpStatus.INTERNAL_SERVER_ERROR;
  console.log(`ERROR occurred: ${error.stack}`);
  res.status(errorCode);
  res.send(`${errorCode} | Sorry, our application is experiencing a problem!`);
};
