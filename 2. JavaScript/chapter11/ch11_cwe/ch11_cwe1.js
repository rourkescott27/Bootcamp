//--Specifying events--//
//--Specifying events with HTML--//
/* function magic() {
    console.log('O o o it\'s magic, you know !')
}*/

//----Specifying events with JavaScript----//
// document.getElementById("unique").onclick = magic;

//-----Specifying events with event listeners----/
// document.getElementById("unique").addEventListener("click", magic);
// document.getElementById("unique").addEventListener("click", function () { magic() });

//----------------------------------------------------------------------------//
//-----The onload event handler-----/
// window.onload = function () {
//     alert('Window loaded')
// };

/* document.addEventListener("DOMContentLoaded", (e) => {
   alert('DOM Loaded');
});*/

//-----HTML-----//
/* function unique() {
    alert('DOM loaded')
};*/

//---------------------------------------------------------------------------//
//-----Mouse event handlers-----//
/*function changeColor() {
   document.getElementById("divvy").style.backgroundColor = 'cyan';
} */

//-----Let's look at a similar slightly more complicated example.-----//
/* window.onload = function donenow() {
    let divvy = document.getElementById("divvy");
    divvy.addEventListener("mousedown", function () { changeColor(this, "green"); });
    divvy.addEventListener("mouseup", function () { changeColor(this, "yellow"); });
    divvy.addEventListener("dblclick", function () { changeColor(this, "black"); });
    divvy.addEventListener("mouseout", function () { changeColor(this, "blue"); });
}

function changeColor(el, color) {
    el.style.backgroundColor = color;
}*/

//---------------------------------------------------------------------------//
//-----The event target property-----//
/* function triggerSomething() {
    console.dir(event.target);
    console.log(event.type);
    console.log(event.target);
}*/

function sendInfo () {
    let p = event.target.parentElement;
    message('Welcome ' + p.firstname.value + " " + p.lastname.value);
}

function message(m) {
    document.getElementById("welcome").innerHTML = m;
}