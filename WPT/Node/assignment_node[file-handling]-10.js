var fs = require("fs");

let filepath = "./Q10/customer.json";

// Reading file synchronously
let objBuffer = fs.readFileSync(filepath, (err, data) => {
    if (err) {
        console.error(err.message);
        return;
    }
});

// parsing json object from buffer
var obj = JSON.parse(objBuffer.toString());

for (const customer of obj) {
    console.log("Name :", customer.name, "\nContact :", customer.phoneNumber, "\n");
}