//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\// 
//------------------------------Chapter projects--------------------------------\\
// Project - Manipulating an array \\
// Take the following array:
/*const theList = ['Laurence', 'Svekis', true, 35, null, undefined,
    { test: 'one', score: 55 }, ['one', 'two']];

// • Remove the first item and the last item.
theList.shift();

// • Add FIRST to the start of the array.
theList.unshift('FIRST');

// • Assign hello World to the fourth item value.
theList.splice(4, 1, 'hello world');

// • Assign MIDDLE to the third index value.
theList.splice(2, 2, 'MIDDLE');

// • Add LAST to the last position in the array.
theList.splice(4, 4, 'LAST');

// • Output it to the console.
console.log(theList);*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Project - Company product catalog \\
// 1. Create an array to hold an inventory of store items.
const dealershipInventory = [];

// 2. Create three items, each having the properties of name, model, cost, and quantity.
let car1 = {
    name: 'BMW',
    model: 'X5 M Competetion',
    cost: 2649990,
    quantity: 2
};

let car2 = {
    name: 'Porche',
    model: '911 GT3 RS',
    cost: 4153000,
    quantity: 1
};

let car3 = {
    name: 'Audi',
    model: 'R8 V10 Plus',
    cost: 3594100,
    quantity: 4
};

// 3. Add all three objects to the main array using an array method, and then log
//    the inventory array to the console.
dealershipInventory.push(car1, car2, car3);
console.log(dealershipInventory);

// 4. Access the quantity element of your third item, and log it to the console.
//    Experiment by adding and accessing more elements within your data structure.
console.log(dealershipInventory[2].quantity);