let x = 1000;

(function(){
    let x = 2000;
    console.log(x)
})();

let result = (()=>{
    let x = 3000;
    return x;
})();


let result2 = ((y)=>{
    let x = 3000;
    return y;
})(4000);

console.log("x is " + x);
console.log("result is " + result);
console.log("result2 is " + result2);