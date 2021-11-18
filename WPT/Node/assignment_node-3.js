var my = require("./Q3/mymodule");

var a = Math.round(Math.random() * 100);

console.log("Factorial of", a, ":", my.factorial(a));
console.log("Is", a, "a prime number :", my.myprime(a) ? "Yes" : "No");
console.log("Table of ", a, ":");
my.printable(a);