var calc = require("./Q2/calc");

var a = 25;
var b = 60;
var c = 40;

console.log("A=25, B=60, C=40");
console.log("a + b", calc.add(a, b));
console.log("a - b", calc.substract(a, b));
console.log("a * b", calc.multiply(a, b));
console.log("a / b", calc.substract(a, b));
console.log("a^2", calc.square(a));
console.log("a + b + c", calc.sum(a,b,c));
console.log("min a b c", calc.min(a,b,c));
console.log("max a b c", calc.max(a,b,c));
