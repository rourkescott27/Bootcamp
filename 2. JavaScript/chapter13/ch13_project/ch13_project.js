/* Creating an array of passwords, these are the only 
passwords that will evaluate to true*/
const allowed = ["1234", "pass", "apple"];

/*This function will check if the 'allowed' array passwords, match the passwords 
passed to the checker function*/
function passwordChecker(pass) {
    return allowed.includes(pass);
}

/*In short this function will check to see if the password is valid and 
upon the result either resolve with the status of true or reject with 
the status of false and return the checked results*/ 
function login(password) {
    return new Promise((resolve, reject) => {
        if (passwordChecker(password)) {
            resolve({
                status: true
            });
        }
        else {
            reject({
                status: false
            });
        }

    });
}

/* This function will check if the Promise is fulfilled or rejected, if fulfilled 
the '.then' method will be returned and the associated code will be executed ie
logging the succeeding code, if the Promise gets rejected the '.catch' method
will be retured, so as to "catch" the error, preventing it from causing problems
with the program and then also logging the succeeding code*/
function checker(pass) {
    login(pass)
        .then(token => {
            console.log("Approve:");
            console.log(token);
        })
        .catch(value => {
            console.log("Reject:");
            console.log(value);
        })
}

checker("1234");
checker("wrong");