var str = require("./Q6/string");

console.log("Palindrome:")
console.log("Car =", str.palindrome("car") ? "Yes" : "No");
console.log("Racecar =", str.palindrome("racecar") ? "Yes" : "No");
console.log();
console.log("Upper Case 'hello world' :", str.upper("hello world"));
console.log();
console.log("Starts with www :");

let sites = ["www.google.com",
             "www.msn.com",
             "www.amazon.co.in",
             "in.answers.yahoo.com",
             "en.m.wikipedia.com",
             "codehs.gitbooks.io",
             "www.coderanch.com"]

str.search(...sites);
