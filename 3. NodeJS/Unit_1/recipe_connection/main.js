"use strict";
const cities = require('cities');
var myCity = cities.zip_lookup('10016');
console.log(myCity);

const adding = require('./secondary');
console.log(adding.addNum(50, 50));
