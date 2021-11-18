var fs = require("fs");

// Reading file & displaying the output
fs.readFile("./Q8/emp.txt", (err, data) => {
    if (err) {
        console.log(err.message);
        return;
    }
    
    // seprating output by lnew line
    let lines = data.toString().split("\n");
    
    // Extracting salary & diplaying salary
    let sal = 0;
    for (const line of lines) {
        sal += parseInt(line.split(":")[3]);
    }
    console.log("Total Salary :",sal);
});