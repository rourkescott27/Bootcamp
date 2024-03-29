const output = document.querySelector(".output");
const myValue = document.querySelector("input");
const btn1 = document.querySelector("button");
const url = "ch15_project2.json";
btn1.addEventListener("click", addToList);
let localData = localStorage.getItem("myList");
let myList = [];
window.addEventListener("DOMContentLoaded", () => {
    output.textContent = "Loading......";
    if (localData) {
        myList = JSON.parse(localStorage.getItem("myList"));
        output.innerHTML = "";
        myList.forEach((el, index) => {
            maker(el);
        });
    } else {
        reloader();
    }
});

function addToList() {
    if (myValue.value.length >= 3) {
        const myObj = {
            "name": myValue.value
        }
        myList.push(myObj);
        maker(myObj);
        savetoStorage();
    }
    myValue.value = "";
}

function savetoStorage() {
    console.log(myList);
    localStorage.setItem("myList", JSON.stringify(myList));
}

function reloader() {
    fetch(url).then(rep => rep.json())
        .then((data) => {
            myList = data;
            myList.forEach((el, index) => {
                maker(el);
            });
            savetoStorage();
        });
}

function maker(el) {
    const div = document.createElement("div");
    div.innerHTML = `${el.name}`;
    output.append(div);
}
