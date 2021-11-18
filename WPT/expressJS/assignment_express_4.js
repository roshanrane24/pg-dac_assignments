const express = require("express");
const path = require("path");

let mainPage = path.join(__dirname, "Q4/table.html")
let app = express();

app.get("/", (req, res) => {
    res.status(200).sendFile(mainPage);
});

app.get("/table", (req, res) => {
    let temp = [];
    for (let i = 1; i <= 10; i++) {
        temp.push(i * parseInt(req.query.num));
    }

    res.status(200).send(temp);
});

app.listen(8080, () =>  {
    console.log(`[INFO] : Server Started on port ${8080}.`);
});