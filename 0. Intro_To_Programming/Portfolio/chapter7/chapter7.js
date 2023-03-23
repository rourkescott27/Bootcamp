// document.getElementById("lefteye").style.backgroundColor = "purple";
// document.getElementById("righteye").style.backgroundColor = "green";
// document.getElementById("head").style.transform = "rotate(15deg)";

// // Put a 2‐pixel‐wide, solid black border around his body.
// document.getElementById("body").style.border = "2px black solid";

// // Round the corners of his mouth.
// document.getElementById("mouth").style.borderRadius = "4px";

// // Put yellow dots around his right eye.
// document.getElementById("righteye").style.border = "4px yellow dotted";

// // Change his left arm’s color.
// document.getElementById("leftarm").style.backgroundColor = "#FF00FF";

// // Change the text color.
// document.getElementById("body").style.color = "#FF0000";

// // Give Douglas hair. 
// document.getElementById("head").style.borderTop = "5px balck solid";

// // Round the corners of his nose.
// document.getElementById("nose").style.borderRadius = "4px";

// // Change his right arm green.
// document.getElementById("rightarm").style.backgroundColor = "green"

// // Change his lips to pink.
// document.getElementById("mouth").style.backgroundColor = "#FC0FC0";

var rightEye = document.getElementById("righteye");
var leftEye = document.getElementById("lefteye");
var leftArm = document.getElementById("leftarm");
var mouth = document.getElementById("mouth");
rightEye.addEventListener("click", moveUpDown);
leftEye.addEventListener("click", moveUpDown2);
leftArm.addEventListener("click", moveRightLeft);
mouth.addEventListener("click", moveLeftRight);

function moveUpDown(e) {
    var robotPart = e.target;
    var left = 0;
    var top = 0;
    var animation = setInterval(frame, 100);

    function frame() {
        robotPart.style.left = left + "%";
        robotPart.style.top = top + "%";
        left++;
        top++;
        if (left === 20) {
            clearInterval(animation);
        }
    }
}
function moveUpDown2(e) {
    var robotPart = e.target;
    var left = 40;
    var top = 0;
    var animation = setInterval(frame, 100);

    function frame() {
        robotPart.style.left = left + "%";
        robotPart.style.top = top + "%";
        left++;
        top++;
        if (left === 60) {
            clearInterval(animation);
        }
    }
}
function moveRightLeft(e) {
    var robotPart = e.target;
    var left = 40;

    var animation = setInterval(frame, 100);

    function frame() {
        robotPart.style.left = left + "%";
        left++;

        if (left === 71) {
            clearInterval(animation);
        }
    }
}
function moveLeftRight(e) {
    var robotPart = e.target;
    var left = 40;

    var animation = setInterval(frame, 100);

    function frame() {
        robotPart.style.left = left + "%";
        left++;
        if (left === 100) {
            clearInterval(animation);
        }
    }
}