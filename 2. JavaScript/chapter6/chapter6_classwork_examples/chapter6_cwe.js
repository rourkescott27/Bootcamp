//Default or unsuitable paramaters

// function addTwoNumbers(x = 2, y = 3) {
//     console.log(x + y);
// }
// addTwoNumbers();
// addTwoNumbers(6, 6);
// addTwoNumbers(10);
// addTwoNumbers(1, 2, 3, 4);

//Arrow functions(one param arrow function)

// let doingArrowStuff = x => console.log(x);

// doingArrowStuff("Great!");

//Arrow functions(two param arrow function)

// let addTwoNumbers = (x, y) => console.log(x + y);

// addTwoNumbers(5, 3);

// const arr = ["squirrel", "alpaca", "buddy"];
// arr.forEach(e => console.log(e));

// let arr = ["so", "much", "fun"];
// let message = ["JavaScript", "is", ...arr, "and", "very",
//     "powerful"];
// alert(message);

// function addTwoNumbers(x, y) {
//     return (x + y);
// }
// let arr = [5, 9];
// addTwoNumbers(...arr);


// function addFourNumbers(x, y, z, a) {
//     console.log(x + y + z + a);
// }
// let arr = [5, 9];
// let arr2 = [6, 7];
// addFourNumbers(...arr, ...arr2);

// function addFourNumbers(x, y, z, a) {
//     console.log(x + y + z + a);
// }
// let arr = [5, 9, 6, 7];

// addFourNumbers(...arr);

// function someFunction(param1, ...param2) {
//     console.log(param1, param2);
//     }
//     someFunction("hi", "there!", "How are you?");

// let result = addTwoNumbers(4, 5);
// alert(result);

// let resultsArr = [];

// for (let i = 0; i < 10; i++) {
//     let result = addTwoNumbers(i, 2 * i);
//     resultsArr.push(result);
// }
// alert(resultsArr);

// let addTwoNumbers = (x, y) => x + y;

// let result = addTwoNumbers(12, 15);
// console.log(result);

// function testAvailability(x) {
//     console.log("Available here:", x);
// }

// testAvailability("Hi!");
// // console.log("Not available here:", x);

// function doingStuff() {
//     if (true) {
//         var x = "local";
//     }
//     console.log(x);
// }
// doingStuff();

// function doingStuff() {
//     if (true) {
//         console.log(x);
//         let x = "local";
//     }
// }
// doingStuff();

// function doingStuff() {
//     if (true) {
//         console.log(x);
//         var x = "local";
//     }
// }
// doingStuff();

// let x = "local";
// function doingStuff() {

//     if (true) {
//         console.log(x);

//     }
// }
// doingStuff();

// function doingStuff() {
//     if (true) {
//         const X = "local";
//     }
//     console.log(X);
// }
// doingStuff();

// let globalVar = "Accessible everywhere!";
// console.log("Outside function:", globalVar);
// function creatingNewScope(x) {
//     console.log("Access to global vars inside function.", globalVar);
// }
// creatingNewScope("some parameter");
// console.log("Still available:", globalVar);

// let x = "global";
// function doingStuff() {
//     let x = "local";
//     console.log(x);
// }
// doingStuff();
// console.log(x);

// let x = "global";
// function doingStuff(x) {
//     console.log(x);
// }
// doingStuff("param");

// function confuseReader() {
//     x = "Guess my scope...";
//     console.log("Inside the function:", x);
// }
// confuseReader();
// console.log("Outside of function:", x);

// function getRecursive(nr) {
//     console.log(nr);
//     getRecursive(--nr);
// }
// getRecursive(3);

// function getRecursive(nr) {
//     alert(nr);
//     if (nr > 0) {
//         getRecursive(--nr);
//     }
// }
// getRecursive(5);

// function logRecursive(nr) {
//     alert("Started function: " + nr);
//     if (nr > 0) {
//         logRecursive(nr - 1);
//     } else {
//         alert("done with recursion");
//     }
//     alert("Ended function: " + nr);
// }
// logRecursive(3);

// function doOuterFunctionStuff(nr) {
//     console.log("Outer function");
//     doInnerFunctionStuff(nr);
//     function doInnerFunctionStuff(x) {
//         console.log(x + 7);
//         console.log("I can access outer variables:", nr);
//     }
// }
// doOuterFunctionStuff(2);

// function doOuterFunctionStuff(nr) {
//     doInnerFunctionStuff(nr);
//     function doInnerFunctionStuff(x) {
//         let z = 10;
//     }
//     console.log("Not accessible:", z);
// }
// doOuterFunctionStuff(2);

// function doOuterFunctionStuff(nr) {
//     doInnerFunctionStuff(nr);
//     function doInnerFunctionStuff(x) {
//         let z = 10;
//     }
// }
// doInnerFunctionStuff(3);

// (function (nr) {
//     (function () {
//         let z = 10;
//         console.log(z);
//     })(nr);
// })(3);


// doFlexibleStuff(functionVariable);

// function functionVariable() {
//     console.log("Not so secret though.");
// };

// function doFlexibleStuff(executeStuff) {
//     executeStuff();
//     console.log("Inside doFlexibleStuffFunction.");
// };

// let anotherFunctionVariable = function () {
//     console.log("Another anonymous function implementation.");
// }
// doFlexibleStuff(anotherFunctionVariable);

// let youGotThis = function () {
//     console.log("You're doing really well, keep coding!");
// };
// setTimeout(youGotThis, 10000);

// setInterval(youGotThis, 10000);

// let val = 10;
// function tester(val) {
//     val += 10;
//     if (val < 100) {
//         return tester(val);
//     }
//     return val;
// }
// tester(val);
// console.log(val);

// let testFunction = function () {
//     console.log("Hello");
// }();

// (function () {
//     console.log("Welcome");
// })();
// (function () {
//     let firstName = "Laurence";
// })();
// let result = (function () {
//     let firstName = "Laurence";
//     return firstName;
// })();
// console.log(result);
// (function (firstName) {
//     console.log("My Name is " + firstName);
// })("Laurence");

// let test2 = (num) => {return num + 5;}
// console.log(test2(14));

var addFive1 = function addFive1(num) {
    return num + 2;
};
let addFive2 = (num) => num + 2;
console.log(addFive1(14));