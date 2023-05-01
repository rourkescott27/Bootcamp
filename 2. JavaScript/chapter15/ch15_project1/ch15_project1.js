let url = "ch15_project1.json";
fetch(url)
    .then(response => response.json())
    .then(data => {
        console.log(data);
        data.forEach(person => {
            console.log(`${person.first} ${person.last} - ${person.topic}`);
        });
    });