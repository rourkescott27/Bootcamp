//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 7.1 \\
/*class Person {
    constructor(firstname, lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}

let friend1 = new Person('Brandon', 'Smith');
let friend2 = new Person('JC', 'Taljard');

console.log(`Hello ${friend1.firstname} ${friend1.lastname} and ${friend2.firstname} ${friend2.lastname} !`);*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 7.2 \\
/*class Person {
    constructor(firstname, lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    fullName() {
        console.log(`${this.firstname} ${this.lastname}`);
        // return this.firstname + " " + this.lastname; --From answers
    }
}

let friend1 = new Person('Brandon', 'Smith');
let friend2 = new Person('JC', 'Taljard');

friend1.fullName();
friend2.fullName();*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Exercise 7.3 \\
class Animals {
    constructor(species, sounds, names) {
        this.species = species;
        this.sounds = sounds;
        this.names = names;
    }
    introduction() {
        console.log(`Hi my name is ${this.names}, I am a ${this.species} and this is the sound I make "${this.sounds}!!"`);
        // console.log('Hi my name is ' + this.names + ' I am a ' + this.species + ' and this is the sound I make ' + this.sounds + '!!');
    }
}

Animals.prototype.sleeping = function () {
    return this.names + ' loves sleeping!';
}

let animal1 = new Animals('Tiger', 'Roar', 'Tiny');
let animal2 = new Animals('Dog', 'Woof', 'Kylo');

console.log(animal1.sleeping());
console.log(animal2.introduction());
console.log(animal2);









