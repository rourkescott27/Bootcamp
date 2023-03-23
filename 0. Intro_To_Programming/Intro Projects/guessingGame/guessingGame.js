var secret = Math.floor(Math.random() * 10) + 1;
var answer = prompt("Guess the secret number between 1 and 10");
var guess = parseInt(answer);

secretNumber();

function secretNumber() {

  while (guess !== secret) {
    guess = parseInt(prompt("Please keep guessing"))

    if (guess > secret) {
      alert("Unlucky your guess is too high");
    } else if (guess < secret) {
      alert("Unlucky your guess is too low");
    }
  }
  if (guess === secret) {
    alert("Well done you found the secret number !!!");
  }

}