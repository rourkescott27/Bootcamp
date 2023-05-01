const url = "exercise15.1.json";
fetch(url).then(rep => rep.json())
    .then((data) => {
        data.forEach((el) => {
            console.log(`${el.name} = ${el.status}`);
        });
    });