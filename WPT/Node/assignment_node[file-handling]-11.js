var fs = require("fs");

let dir = "./Q11";
let filepath = "/book.txt";
books = [
    {
        "bookid": 1,
        "name": "Dune",
        "author": "Frank Herbert",
        "price": 15.99
    },
    {
        "bookid": 2,
        "name": "The Republic",
        "author": "Plato",
        "price": 9.99
    },
    {
        "bookid": 3,
        "name": "1984",
        "author": "George Orwell",
        "price": 9.99
    }
]

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
})

// creating string from object & writing data to file
objBook = JSON.stringify(books);

fs.writeFile(dir + filepath, objBook, (err) => {
    if (err) {
        console.error(err.message);
        return;
    }


    console.log("Sucessfully written to file.");
});