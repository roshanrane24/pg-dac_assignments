var shop = require("./Q4/shopping");

var amount1 = 1507;
var amount2 = 3706;
var amount3 = 9260;

console.log("Amount :", amount1);
console.log("Discount :", shop.calculateDiscount(amount1))
console.log("GST :", shop.calculateGST(amount1))
console.log();
console.log("Amount :", amount2);
console.log("Discount :", shop.calculateDiscount(amount2))
console.log("GST :", shop.calculateGST(amount2))
console.log();
console.log("Amount :", amount3);
console.log("Discount :", shop.calculateDiscount(amount3))
console.log("GST :", shop.calculateGST(amount3))