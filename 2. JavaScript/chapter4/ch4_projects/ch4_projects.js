//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
//--------------------------- Chapter projects ---------------------------------\\
// Evaluating a number game \\
/*let userInput = parseInt(prompt('See if your number mathches the secret number by entering a random number between 0 - 10.'));
let randomNum = Math.floor(Math.random() * 11);

if (userInput > randomNum) {
    alert('Your number is greater than the secret number :(');
} else if (userInput === randomNum) {
    alert('Well done you guessed the secret number!!');
} else {
    alert('Your number is less than the secret number :(');
}*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Friend checker game \\
/*let isFriend = prompt('Enter your name to see if you are my friend.');

switch (isFriend) {
    case 'Brandon':
        console.log('You are my best friend !!');
        break;
    case 'Jc':
    case 'Duvan':
        console.log('You are my friend !');
        break;

    default:
        console.log('You are not my friend.....Yet!')
}*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Rock Paper Scissors game \\
let arr = ['Rock', 'Paper', 'Scissors'];
let player = Math.floor(Math.random() * 3);
let computer = Math.floor(Math.random() * 3);
let msg = `Player:${arr[player]} vs Computer:${arr[computer]}` + '|=>|';

if (player === computer) {
    msg += 'It\'s a draw!';
} else if (player > computer) {
    if (computer === 0 && player === 2) {
        msg += 'Computer wins!';
    } else {
        msg += 'Player wins!';
    }
} else {
    if (player === 0 && computer === 2) {
        msg += 'Player wins!';
    } else {
        msg += 'Computer wins!';
    }
}

console.log(msg);