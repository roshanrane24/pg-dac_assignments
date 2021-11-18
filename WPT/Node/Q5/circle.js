function calcArea(radius) {
    return Math.PI * radius * radius;
}

function calcCirrcumference(radius) {
    return 2 * Math.PI * radius;
}

function calcDiameter(radius) {
    return radius * 2;
}

module.exports = {calcArea, calcCirrcumference, calcDiameter};