//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//
// Chapter project \\
// Math multiplication table \\
const multiTable = [];
const val = 13;
for (let i = 0; i < val; i++) {
    let tempArr = [];
    for (let x = 0; x < val; x++) {
        tempArr.push(i * x);
    }
    multiTable.push(tempArr);
}
console.table(multiTable);

