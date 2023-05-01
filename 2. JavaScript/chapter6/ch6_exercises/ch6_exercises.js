// Exercise 6.1 \\
/*let x = 10;
let y = 5;

function adding(x, y) {
    return x + y;
}

console.log(adding(x, y));
console.log(adding(20, 30));*/

//\\--//\\--//\\--//\\--//\\--//\\
/*let i = parseInt(prompt('Enter a numeric value'));
let a = parseInt(prompt('Enter a numeric value'));

addOn();

function addOn() {
    let total = i + a;
    alert(`Your total value is ${total}!`);
}*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 6.2 \\
/*let adjectives = ['beautiful', 'nice', 'upstanding', 'clever', 'great'];

descriptive();
function descriptive() {
    let ask = prompt('Please enter your first name');
    let randomIndex = Math.floor(Math.random() * adjectives.length);
    let randomWord = adjectives[randomIndex];
    alert(`${ask}, you are a ${randomWord} person!`);
}*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 6.3 \\
/*let num1 = parseInt(prompt('Enter a numeric value'));
let num2 = parseInt(prompt('Enter a numeric value'));
let minusAdd = prompt('Enter a plus or minus operator');


plusAndMinus(num1, num2, minusAdd);

function plusAndMinus(x, y, operator) {
    if (operator == '-') {
        let subtract = x - y;
        console.log(`Your total is ${subtract}!`);
    } else if (operator == '+') {
        let plus = y + x;
        console.log(`Your total is ${plus}!`);
    } else {
        console.log('Your total is ' + (y + x)+'!');
    }
}*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 6.4 \\
/*let arr = [];

for (let i = 0; i < 10; i++) {
    let val1 = i * 5;
    let val2 = i * i;
    let result = plusAndMinus(val1, val2, '-');
    arr.push(result);
}

console.log(arr);

function plusAndMinus(x, y, operator) {
    if (operator == '-') {
        let subtract = x - y;
        return subtract;
    } else if (operator == '+') {
        let plus = y + x;
        return plus;
    } else {
       return x + y;
    }
}*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 6.5 \\
/*let x = 1000;

(function () {
    let x = 2000;
    console.log(x)
})();

let result = (() => {
    let x = 3000;
    return x;
})();


let result2 = ((y) => {
    let x = 3000;
    return y;
})(4000);

console.log(`x is ${x}`);
console.log(`result is ${result}`);
console.log(`result2 is ${result2}`);*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 6.6 \\
/*function myFunc(x) {
    //console.log(x); 
    if (x === 0) {
        return 1;
    } else {
        return x * myFunc(--x);
    }
}
console.log(myFunc(4));*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 6.7 \\
/*let start = 10;

countDown(start);
function countDown(x) {
    console.log(x);
    if (x < 1) {
        return;
    }
    return countDown(x - 1);
}

countDown2(start);
function countDown2(y) {
    console.log(y);
    if (y > 0) {
        y--;
        return countDown2(y);
    }
    return;
}*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 6.8 \\
let myFunc = function(x) {
    console.log(x);
}
myFunc('Hello'); //can't call the function before declaration

myFunc2('You');
function myFunc2(i) {
    console.log(i);
}












