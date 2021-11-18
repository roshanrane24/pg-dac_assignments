const express = require("express");
const fs = require("fs");
const path = require("path");

let mainPage = path.join(__dirname, "Q1/str2list.html");
let app = express();

// Mainpage
app.get("/", (req, res) => {
    res.status(200).sendFile(mainPage);
});

// response for query
app.get("/unorderedList", (req, res) => {
    let li = "The Parameters are<ul>";
    
    // appending items to list
    for (const q of Object.keys(req.query)) {
        li += `<li>${req.query[q]}</li>`
    }
    li += "</ul>";

    // sending response
    res.status(200).send(li);
});

app.listen(8080, () => {
    console.log("Server started listening on port 8080");
});