var fs = require("fs");
const { exit } = require("process");

emps = [
    {empid: 1001,
     ename: "Harry",
     dept: "Sales",
     sal:23000},
    {empid: 1002,
     ename: "Sarita",
     dept: "Accounts",
     sal:20000},
    {empid: 1002,
     ename: "Monika",
     dept: "TechSupport",
     sal: 35000}];

let dir = "./Q9";
let file = "/emp_from_objects.txt";

fs.mkdir(dir, { recurssive: true }, (err) => {
    if (err) {
        if (err.code === "EEXIST") {
            console.warn(err.message);
        } else {
            console.error(err.message);
            console.error("Stopping Program.");
            exit(1);
        }
        return;
    }
    console.log("Successfully created directory :",)
});

let data = "";

for (const emp of emps) {
    let tempArr = []

    for (const prop of Object.keys(emp)) {
        tempArr.push(emp[prop]);
    }
    
    data += tempArr.join(":") + "\n"
}

fs.writeFile(dir + file, data, (content, err) => {
    if (err) {
        console.error(err.message);
    }
    console.log("Writen to file");
});