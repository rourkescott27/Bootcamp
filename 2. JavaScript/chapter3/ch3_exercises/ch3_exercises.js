//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
//-----------------------------Chapter Exercises--------------------------------\\
// Exercise 3.1 \\
// 1. Create an array to use as your shopping list with 3 items: "Milk," "Bread," and "Apples."
/*let items = ['Milk', 'Bread', 'Apples'];

// 2. Check your list length in the console.
console.log(items.length);

// 3. Update "Bread" to "Bananas."
items[1] = 'Bananas';

// 4. Output your entire list to the console.
console.log(items);*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\// 
// Exercise 3.2 \\
// 1. Create an empty array to use as a shopping list.
/*let shoppingList = [];

// 2. Add Milk, Bread, and Apples to your list.
shoppingList.push('Milk', 'Bread', 'Apples');

// 3. Update "Bread" with Bananas and Eggs.
shoppingList.splice(1, 1, 'Bananas', 'Eggs');

// 4. Remove the last item from the array and output it into the console.
shoppingList.pop();

// 5. Sort the list alphabetically.
shoppingList.sort();

// 6. Find and output the index value of Milk.
console.log(shoppingList.indexOf('Milk'));

// 7. After Bananas, add Carrots and Lettuce.
shoppingList.splice(1, 0, 'Carrots', 'Lettuce');

// 8. Create a new list containing Juice and Pop.
let shoppingList2 = ['Juice', 'Pop'];

// 9. Combine both lists, adding the new list twice to the end of the first list.
let combinedList = shoppingList.concat(shoppingList2).concat(shoppingList2);

// 10. Get the last index value of Pop and output it to the console.
let findValue = combinedList.find(e => e === 'Pop', 9 );
console.log(findValue);

// 11. Your final list should look like this:
console.log(combinedList);*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\// 
// Exercise 3.3 \\
// 1. Create an array containing three values: 1, 2, and 3.
/*let arr = [1, 2, 3];

// 2. Nest the original array into a new array three times.
let newArr = [arr, arr, arr];

// 3. Output the value 2 from one of the arrays into the console.
console.log((newArr[0][1]), (newArr[1][1]), (newArr[2][1]));*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\// 
// Exercise 3.4 \\
// 1. Create a new myCar object for a car. Add some properties, including, but not
// limited to, make and model, and values for a typical car or your car. Feel free
// to use booleans, strings, or numbers. 

/*let myCar = {
    make: 'BMW',
    model: 'M3 Touring',
    colour: 'Black',
    year: 2023,
};

// 2. Create a variable that can hold the string value color. This variable 
// containing a string value color can now be used to reference the property 
// name within myCar. Then, use the variable within the square bracket notation 
// to assign a new value to the color property in myCar. 
let propColour = 'colour';
myCar[propColour] = 'Isle of Man Green Metallic';

// 3. Use that same variable and assign a new property string value to it, such as 
// forSale. Use the bracket notation once again to assign a new value to the 
// forSale property to indicate whether the car is available for purchase. 
propColour = 'forSale';
myCar[propColour] = false;

// 4. Output make and model into the console.
console.log(myCar['make'], myCar['model']);

// 5. Output the value of forSale into the console.
console.log(myCar['forSale']);

//Showing myCar object in its totality.
console.log(myCar);*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\// 
// Exercise 3.5 \\
// 1. Create an object named people that contains an empty array that is called friends.
let people = { friends: [] };

/* 2. Create three variables, each containing an object, that contain one of your
friend's first names, last names, and an ID value. */
let person1 = {
    firstName: 'Brandon',
    lastName: 'Smith',
    idVal: 1
};

let person2 = {
    firstName: 'JC',
    lastName: 'Taljard',
    idVal: 2
};

let person3 = {
    firstName: 'Duvan',
    lastName: 'van Duyker',
    idVal: 3
}; 

// 3. Add the three friends to the friend array.
people.friends.push(person1, person2, person3);

// 4. Output it to the console.
console.log(people);