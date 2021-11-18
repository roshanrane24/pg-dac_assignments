var fs = require("fs");
const { exit } = require("process");


// declaring name array to write
var names = ["name1", "name2", "name3", "name4", "name5",
    "name6", "name7", "name8", "name9", "name10",
    "name11", "name12", "name13", "name14", "name15"];

// Creating output directory
fs.mkdir("./Q7", { recurssive: true }, (err) => {
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

// writing data to output file
fs.writeFile("./Q7/names.txt", names.join("|"), (err) => {
    if (err) {
        console.log(err.message);
        return;
    }

    console.log("Writen to file");
});
