//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
//----------------------------- Chapter projects -------------------------------\\
//------------------------ Create a recursive function -------------------------//
/*let countUp = function (val) {
    console.log(val);
    if (val < 10) {
        return countUp(val + 1);
    }
    return; 
}

countUp(0);*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
//----------------------------- Set timeout order ------------------------------\\
let arrowFunc1 = () => console.log('one');
let arrowFunc2 = () => console.log('two');

let myFunc3 = () => {
    console.log('three');
    arrowFunc1();
    arrowFunc2();
}

let myFunc4 = () => {
    console.log('four');
    setTimeout(arrowFunc1, 0);
    myFunc3();
}

myFunc4();

