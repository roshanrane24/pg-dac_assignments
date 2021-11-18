function add (a,b) {
    return sum(a,b);
}

function substract(a, b) {
    return a - b;
}

function multiply (a, b) {
    return a * b;
}

function divide (a, b) {
    return a / b;
}

function square(a) {
    return a * a;
}

function sum() {
    let res = 0;

    for (arg of arguments)
        res += parseInt(arg);

    return res;
}

function min(a, b, c) {
    return Math.min(a, b, c);
}

function max(a, b, c) {
    return Math.max(a, b, c);
}

module.exports = {add, substract, multiply, divide, square, sum, min, max};