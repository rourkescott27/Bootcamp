//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\// 
//-----------------------------Chapter Exercises--------------------------------\\
// Exercise 4.1 \\
// 1. Create a variable with a Boolean value.
/*let javaScript = false;

// 2. Output the value of the variable to the console.
console.log(javaScript);

// 3. Check whether the variable is true and if so, output a message to the console.
if (javaScript) {
    console.log(`It is ${javaScript}`)
} if (!javaScript) {
    console.log('It is false')
};*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\// 
// Exercise 4.2 \\
// 1. Create a prompt to ask the user's age
/*let userAge = prompt('How old are you ?');

// 2. Convert the response from the prompt to a number
let ageInt = Number(userAge);

// 3. Declare a message variable that you will use to hold the console message for the user
let msg;

// 4, 5 and 6.
if (ageInt >= 21) {
    msg = 'You may enter the venue and purchase alcohol.';
} else if (ageInt >= 19) {
    msg = 'You may enter the venue but cannot purchase alcohol.';
} else {
    msg = 'You have to be at least 19 years old to enter the venue and at least 21 years old to purchase alcohol !';
}

// 7. Output the response message variable to the console
console.log(msg);*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\// 
// Exercise 4.3 \\
// 1. Create a Boolean value for an ID variable
/*let id = true;

// 2. Using a ternary operator, create a message variable that will check whether
//    their ID is valid and either allow a person into a venue or not.
let msg = id == true ? 'ID is valid' : 'Id is invalid';

// 3. Output the response to the console
console.log(msg);*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\// 
// Exercise 4.4 \\
/*const randomVar = Math.floor(Math.random() * 6);
let ans;
let input = prompt('Ask me which number will be generated between 0 and 5!');


switch (randomVar) {
    case 0:
        ans = 'I generated zero for you!';
        break;

    case 1:
        ans = 'This time it was one!';
        break;

    case 2:
        ans = 'Why do people like two so much ?';
        break;

    case 3:
        ans = 'It took me a long time to find this three.';
        break;

    case 4:
        ans = 'Four is for "  ".'
        break;

    case 5:
        ans = 'High "FIVE"!';
        break;

    default:
        ans = 'Something went wrong, I can\'t find your number!';
        break;
}

let response = `You asked me ${input} and this is what I have for you: ${ans}`;
alert(response);*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\// 
// Exercise 4.5 \\
let prize = prompt('Please enter a number between 1-10.');
let prizeNum = Number(prize);

switch (prizeNum) {
    case 1:
    case 10:
        msg = 'You have won a luxury holiday to Bali!';
        break;

    case 2:
    case 9:
        msg = 'You have won your dream car!';
        break;

    case 3:
        msg = 'You won a million rands!';
        break;

    case 4:
    case 8:
        msg = 'You won a 3 day cruise to Mozambique!';
        break;

    case 5:
    case 6:
    case 7:
        msg = 'You have won a years worth of groceries!';
        break;

    default:
        msg = 'Something went wrong please try again.';
        break;
}

let output = `CONGRATULATIONS!!!! ${msg}`;
alert(output);





























