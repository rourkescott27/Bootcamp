// Exercise 5.1 \\
/*let max = 5;
let randomNum = Math.floor(Math.random() * 6);
let bool = false;

while (!bool) {
    let userGuess = prompt(`Guess the secret number between 1 - ${max}!`);
    userGuess = Number(userGuess);
    
    if (userGuess === randomNum) {
        bool = true;
        alert('Well done you found the secret number!');
    } else if (userGuess > randomNum) {
        alert('Guess is too high!');
    } else {
        alert('Guess is too low!');
    }
}*/

//////////////////////////////////////////////////////////////////////////////////
// Exercise 5.2 \\
/*let start = 0;
let step =  2;
do {
    console.log(start);
    start += step;
} while (step <= 100);*/

//////////////////////////////////////////////////////////////////////////////////
// Exercise 5.3 \\
/*let myWork = [];
for (let i = 0; i < 10; i++) {
    let status = (i % 2 ? true : false);
    let lesson = {
        name: `'Lesson${i}'`, status: `${status}`
    };
    myWork.push(lesson);
}

console.log(myWork);*/

//////////////////////////////////////////////////////////////////////////////////
// Exercise 5.4 \\
/*let myTable = [];
let rows = 5;
let columns = 8;
let counter = 0;
for (let i = 0; i < rows; i++) {
    let temp = [];
    for (let y = 0; i < columns; y++) {
        counter++;
        temp.push(counter);
    }
    myTable.push(temp);
}
console.table(myTable);*/

//////////////////////////////////////////////////////////////////////////////////
// Exercise 5.5 \\
/*const grid = [];
const cells = 64;
let counter = 0;
let rowArr;

for (let i = 0; i < cells + 1; i++) {
    if (counter % 8 == 0) {
        if (rowArr != undefined) {
            grid.push(rowArr);
        }
        rowArr = [];
    }
    counter++;
    let tempCount = counter;
    rowArr.push(tempCount);
}

console.table(grid);*/

//////////////////////////////////////////////////////////////////////////////////
// Exercise 5.6 \\
/*let empty = [];
for (let x = 0; x < 10; x++) {
    empty.push(x + 1);
}
console.log(empty);

for (let i = 0; i < empty.length; i++){
    console.log(empty[i]);
}

for (let numbers of empty) {
    console.log(numbers);
}*/

//////////////////////////////////////////////////////////////////////////////////
// Execrise 5.7 \\
/*let car = {
    model: 'Porsche 911 GT3 RS',
    make: 'BMW',
    colour: 'Black'
};

for (let prop in car) {
    console.log(prop, car[prop]);
}

let car2 = ['Porsche 911 GT3 RS', 'BMW', 'Black'];*/

// for (let props in car2) {
//     console.log(props, car2[props]);
// }

//////////////////////////////////////////////////////////////////////////////////
// Exercise 5.8 \\
let stringVar = '';
let numSkip = 7;
for (let i = 0; i < 10; i++) {
    if (i === numSkip) {
        continue;
    }
    stringVar += i;
}
console.log(stringVar);
