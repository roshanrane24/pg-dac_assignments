const { response } = require("express");
const express = require("express");
const path = require("path");
const fs = require("fs");

let mainPage = path.join(__dirname, "/Q3/orders.html")
let opFile = path.join(__dirname, "Q3/orders.txt");
let app = express();

// creating output file
fs.access(opFile, (err) => {
    if (err) {
        fs.writeFile(opFile, "OrderId|CustomerName|BillingDate|ShippingDate|OrderTotal\n", (err) => {
            if (err) {
                console.error("[ERR] : Error while creating file\n", err.message);
            }
            console.log("[INFO] : Successfully created to file.");
        })
    }
});

app.get("/", (req, res) => {
    res.status(200).sendFile(mainPage);
});

app.get("/save", (req, res) => {
    let temp = [];
    for (const detail of Object.keys(req.query)) {
        temp.push(req.query[detail]);
    }

    fs.appendFile(opFile, temp.join("|") + "\n", (err) => {
        if (err) {
            console.error("[ERR : Error saving data\n", err.message);
            return;
        }
        console.log(`[INFO] : Successfully saved data for order id ${req.query.oid}`);
        res.status(200).sendFile(mainPage);
    });
});

app.get("*", (req, res) => {
    res.status(404).send("<h1>404 Not found</h1>")
    console.warn("[WARN] : (404)Invalid request received");
})

app.listen(8080, () =>  {
    console.log(`[INFO] : Server Started on port ${8080}.`);
});