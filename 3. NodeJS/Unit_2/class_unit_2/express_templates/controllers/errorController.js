// Adding middleware for error handling
/*exports.logErrors = (error, req, res, next) => {
    // Logging the errors to the error stack
    console.log(`Logging Error ${error.stack}`);
    console.error(error.stack);
    // Passing the error to the next middleware function
    next(error);
};*/

const httpStatus = require("http-status-codes");
exports.respondNoResourceFound = (error, req, res, next) => { // Added error and next to the params
    let errorCode = httpStatus.NOT_FOUND;
    console.log(`ERROR occurred 404: ${error.stack}`)
    // console.log(errorCode + ' Error');
    res.status(errorCode);
    res.sendFile(`./public/${errorCode}.html`, {
        root: "./"
    });
};

exports.respondInternalError = (error, req, res, next) => {
    let errorCode = httpStatus.INTERNAL_SERVER_ERROR;
    console.log(`ERROR occurred 500: ${error.stack}`)
    res.status(errorCode);
    res.sendFile(`./public/${errorCode}.html`, {
        root: "./"
    });
};