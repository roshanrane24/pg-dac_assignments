const express = require("express");
const path = require("path");

let mainPage = path.join(__dirname, "./Q2/simpleInt.html");
let app = express();

let si = (p, r, t) => {return parseInt(p) * parseInt(r) / 100 * parseInt(t)};

app.get("/", (req, res) => {
    res.status(200).sendFile(mainPage);
})

app.get("/si", (req, res) =>{
    let result = si(req.query.principle, req.query.rate, req.query.time);
    res.status(200).send(`<h1 align="center">Simple Interest</h1><h2 align="center">${result.toString()}</h2>`);
});

app.listen(8080, () => {console.log("Listen on port 8080")});