function isEquilateral(a, b, c) {
    if (a == b && b == c)
        return true
    return false;
}

function calcPerimeter(a, b, c) {
    return a + b + c;
}

module.exports = {isEquilateral, calcPerimeter}