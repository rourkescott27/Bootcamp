//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
//-------------------------------Chapter projects-------------------------------\\
// Word scrambler \\
let ranStr = 'Developer';

function scrambler(str) {
    let maxVal = str.length; 
    let tempStr = '';  
    for (let i = 0; i < maxVal; i++) { 
        console.log(str.length); 
        let ranSelect = Math.floor(Math.random() * str.length); 
        tempStr += str[ranSelect]; 
        console.log(tempStr);
        str = str.substr(0, ranSelect) + str.substr(ranSelect + 1); 
        console.log(str);
    }
    return tempStr; 
}
console.log(scrambler(ranStr)); 

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Countdown timer \\
/*let endDate = 'January 1, 2100';

function countdown() {
    let subDate = Date.parse(endDate) - new Date();
    let days = Math.floor(subDate / (1000 * 60 * 60 * 24));
    let hours = Math.floor((subDate / (1000 * 60 * 60)) % 24);
    let minutes = Math.floor((subDate / 1000 / 60) % 60);
    let seconds = Math.floor((subDate / 1000) % 60);
    return {
        days,
        hours,
        minutes,
        seconds
    };
}

function update() {
    let temp = countdown();
    let output = '';
    for (let prop in temp) {
        output += (`${prop}:${temp[prop]} `);
    }
    console.log(output);
    setTimeout(update, 1000);
}

update();*/


