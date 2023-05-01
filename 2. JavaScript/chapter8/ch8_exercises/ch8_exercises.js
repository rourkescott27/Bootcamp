//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 8.1 \\
/*let uri = "How's%20it%20going%3F"; 
let encoded_uri = decodeURIComponent(uri);
console.log(encoded_uri);

let uri2 = 'How\'s it going?';
let decoded_uri = encodeURIComponent(uri2);
console.log(decoded_uri);

let uri3 = "http://www.basescripts.com?=Hello World";
let encode = encodeURI(uri3);
console.log(encode);*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 8.2 \\
/*let peopleArr = ["Laurence", "Mike", "Larry", "Kim", "Joanne",
    "Laurence", "Mike", "Laurence", "Mike", "Laurence", "Mike"];

let arrFilter = () => {
    return unique = peopleArr.filter(function(element, index, array) { //why do we need 3 paramters?
        console.log(element, index, array.indexOf(element));
        return peopleArr.indexOf(element) == index;
    });
}

console.log(arrFilter());*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 8.3 \\
/*const num = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]; 
let mapped = num.map(x => x * 2);//Arrow function example
console.log(mapped);

const num2 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let anonymous = num2.map(function(x){ //Anonymous function example
    return (x * 2);
});
console.log(anonymous);*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 8.4 \\
/*let rndmString = 'i\'M sTudYinG tO bEcoMe a fUlL StAcK web dEvelOPer';
function converter(str) {
    str = str.toLowerCase();
    let newArr = [];
    let spliter = str.split(" ");
    spliter.forEach(el => {
        let slicer = el.slice(0, 1).toUpperCase() + el.slice(1);
        newArr.push(slicer);
    });
    return newArr.join(" ");
}
console.log(converter(rndmString));*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 8.5 \\
/*let str = 'I love JavaScript';
let lowerStr = str.toLowerCase();
let arr = ['a', 'e', 'i', 'o', 'u'];

arr.forEach((letter, index) => {
    console.log(letter);
    lowerStr = lowerStr.replaceAll(letter, index);
});
console.log(lowerStr);*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 8.6 \\
/*console.log(Math.PI);

let a = 5.7;
console.log(Math.ceil(a));
console.log(Math.floor(a));
console.log(Math.round(a));

let b = Math.random();
console.log(b);

let c = Math.floor(Math.random() * 11);
console.log(c);

let d = Math.floor(Math.random() * 10 + 1);
console.log(d);

let e = Math.floor(Math.random() * 100 + 1);
console.log(e);

function randomNum(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}
for (let i = 0; i < 100; i++) {
    console.log(randomNum(1, 100));
}*/ 

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 8.7 \\
/*let randomDate = new Date(2029, 3, 27);
console.log(randomDate); //Logs full date from date object

let months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sept', 'Oct', 'Nov', 'Dec'];

let day = randomDate.getDate();
console.log('Day:', day);
let year = randomDate.getFullYear();
console.log('Year:', year);
let month = randomDate.getMonth();
console.log('Month:', month);

let randomMonth = `${months[month - 1]} ${day} ${year}`;
console.log(randomMonth);*/






