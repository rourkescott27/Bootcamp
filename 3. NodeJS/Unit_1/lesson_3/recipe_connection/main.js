"use strict";
// Requiring the cities package
const cities = require('cities'); 
// Searching for the city by passing its specific zipcode to the "zip_lookup()" method
var myCity = cities.zip_lookup('10016');
console.log(myCity); // Logging the results

// Requiring the "addNum()" function that was defined in secondary.js
const adding = require('./secondary');
console.log(adding.addNum(50, 50));

