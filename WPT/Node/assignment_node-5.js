var cir = require("./Q5/circle");
var rect = require("./Q5/rectangle");
var tri = require("./Q5/triangle");

let rad = Math.round(Math.random() * 100);

let len = Math.round(Math.random() * 100);
let bre = Math.round(Math.random() * 100);

let a = Math.round(Math.random() * 100);
let b = Math.round(Math.random() * 100);
let c = Math.round(Math.random() * 100);

console.log("Circle:\nRadius =", rad);
console.log("Area =", cir.calcArea(rad));
console.log("Circumference =", cir.calcCirrcumference(rad));
console.log("Diameter =", cir.calcDiameter(rad));
console.log();
console.log("Rectangle:\nLength =", len, "Breadth =", bre);
console.log("Area =", rect.calcArea(len, bre));
console.log();
console.log("Triangle:\na =", a, "b =", b, "c =", c);
console.log("isEquilateral =", tri.isEquilateral(a, b, c));
console.log("Perimeter =", tri.calcPerimeter(a, b, c));