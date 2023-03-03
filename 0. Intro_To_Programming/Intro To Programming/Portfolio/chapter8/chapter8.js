var dreamCar = {
    make: "Oldsmobile",
    model: "1998",
    color: "brown",
    year: 1983,
    bodyStyle: "Luxury Car",
    price: 4500,
}
// alert("The type of dream car is : " + typeof dreamCar);
document.getElementById("pricetag").innerHTML = dreamCar.price;
document.getElementById("modelyear").innerHTML = dreamCar.model;
document.getElementById("body").style.backgroundColor = "red";