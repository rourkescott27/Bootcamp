//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
//-----------------------------Chapter projects---------------------------------\\
// Employee tracking app \\
/*class Employees {
    constructor(firstname, lastname, yearsWorked) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearsWorked = yearsWorked;
    }

}
Employees.prototype.empDetails = function () {
    console.log(`First Name: ${this.firstname} |Last Name: ${this.lastname} |Years of Service: ${this.yearsWorked}`);
}

let arr = [];
let employee1 = new Employees('Jon', 'Doe', 10);
let employee2 = new Employees('Mary', 'Jane', 7);
arr.push(employee1, employee2);
console.log(employee1.empDetails(), employee2.empDetails()); //Displays undefined in console?

arr.forEach((person) => {
    console.log(person.empDetails())
});*/

/*for (let i = 0; i < arr.length; i++) {
    console.log(arr[i]);
}*/ //Could this work ?

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Menu items price calculator \\
class Menu {
    #bread = 15;
    #milk = 28;
    constructor(tot1, tot2) {
        this.t1 = tot1;
        this.t2 = tot2;
    }
    calculate() {
        return (this.t1 * this.#bread) + (this.t2 * this.#milk);
    }
    get total() {
        return this.calculate();
    }
}

let price1 = new Menu(1, 1);
let price2 = new Menu(2, 3);
let price3 = new Menu(5, 1);
let price4 = new Menu (20, 25);
let prices = (`The prices of the four different selections are #1:R${price1.total}, #2:R${price2.total}, #3:R${price3.total}, #4:R${price4.total}.`);
console.log(prices);
