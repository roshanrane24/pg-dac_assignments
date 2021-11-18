var fs = require("fs");
let filepath = "./Q12/simple.txt"

let file = fs.readFileSync(filepath).toString().split("\n");

for (const i in file) {
    console.log(parseInt(i) + 1, file[i]);
}