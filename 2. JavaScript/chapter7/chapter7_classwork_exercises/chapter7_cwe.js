//------------------------CLASSES AND OBJECTS-------------------------------//
/* function Dog(dogName, weight, color, breed) {
    this.dogName = dogName;
    this.weight = weight;
    this.color = color;
    this.breed = breed;
}

let dog1 = new Dog("Jacky", 30, "Brown", "Labrador");
let dog2 = new Dog("Kylo", 25, "Black and White", "Pitbull" )
let dog3 = new Dog("Stukkie", 12, "White and Brown", "Jack Russel Terrier")

console.log(dog1);
console.log(dog2);
console.log(dog3); */


//---------------------------CLASS SYNTAX-----------------------------------//
/* class Dog {
    constructor(dogName, weight, color, breed) {
        this.dogName = dogName;
        this.weight = weight;
        this.color = color;
        this.breed = breed;
    }
}
let dog1 = new Dog("JavaScript", 2.4, "Brown", "chihuahua");
let dog2 = new Dog("Python", 20, "Brown", "Boerboel");

console.log(dog1);
console.log(dog2); */

//---------------CONSTRUCTORS,METHODS ,GETTERS AND SETTERS---------------//
/* class Person {
    constructor(firstname, lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}

let p = new Person("Maaike", "van Putten");

let p1 = new Person("Maaike");

console.log(p);
console.log("Hi", p.firstname);
console.log("Hi", p.firstname, p.lastname);

console.log("Hi", p1.lastname); */



/* class Person1 {
    //--##PROPERTIES##--//
    #firstname;
    #lastname;
    constructor(firstname, lastname = "Doe") {
        this.#firstname = firstname;
        this.#lastname = lastname;
    }
    //-----GETTERS AND SETTERS-----//
    get firstname() {
        return this.#firstname;
    }
    set firstname(firstname) {
        if (firstname.length > 1) {
            this.#firstname = firstname;
        } else {
            alert("Name too short");
        }
    }
    get lastname() {
        return this.#lastname;
    }
    set lastname(lastname) {
        this.#lastname = lastname;
    }
    //---------METHOD---------//
    greet() {
        console.log("Hi there! I'm", this.firstname);
    }
    //---------METHOD---------//
    compliment(name, object) {
        return "That's a wonderful " + object + ", " + name + ".";
    }

}


//---CALLING THE CONSTRUCTOR---//
let p = new Person1("Maaike");
console.log("Hi", p.firstname, p.lastname);

let p2 = new Person1("Mel", "Lee");
console.log("Hi", p2.firstname, p2.lastname);

//---CALLING THE METHODS---//
p.greet();
p2.greet();
console.log(p.compliment("Sarah", "dress"));

//---CALLING GETTER AND SETTER METHOD---//
console.log(p.firstname);
p.firstname = "Po";
console.log(p.firstname); */

//----------------------------INHERITANCE----------------------------//

/* class Vehicle {
    color;
    currentSpeed;
    maxSpeed;
    constructor(color, currentSpeed, maxSpeed) {
        this.color = color;
        this.currentSpeed = currentSpeed;
        this.maxSpeed = maxSpeed;
    }
    move() {
        console.log("Moving at", this.currentSpeed, "km/h");
    }
    accelerate(amount) {
        this.currentSpeed += amount;
    }
}

class Motorcycle extends Vehicle {
    fuel;
    constructor(color, currentSpeed, maxSpeed, fuel) {
        super(color, currentSpeed, maxSpeed);
        this.fuel = fuel;
    }
    doWheelie() {
        console.log("Driving on one wheel!")
    }
}

let motor = new Motorcycle("Black", 0, 250, "Gasoline");
console.log(motor.color);
console.log("Max speed is", motor.maxSpeed, "km/h");

motor.accelerate(50);
motor.move();

let motor2 = new Motorcycle("Green", 60, 200, "Gasoline");
console.log(motor2.color);

motor2.accelerate(60);
motor2.move();
motor2.doWheelie(); */

//-------------------------------PROTOTYPES------------------------------//

class Person {
    firstname;
    lastname;
    constructor(firstname, lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    greet() {
        console.log("Hi there!");
    }
}

Person.prototype.introduce = function () {
    console.log("Hi, I'm", this.firstname);
};

Person.prototype.favoriteColor = "Green";

let p = new Person("Maria", "Saga");
console.log(p.favoriteColor);
p.introduce();
p.greet();
















