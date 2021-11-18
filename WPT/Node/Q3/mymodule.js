function factorial (num) {
    result = 1;

    for (let i = 2; i <= num; i++)
        result *= i;

    return result;
}

function  myprime(num) {

    function loopSq(num) {
        for (let i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    if (num <= 1)
        return true
    else if ([2,3].includes(num)) 
        return false;
    else
        return loopSq(num);
}

function printable(num) {
    for (let i = 1; i <= 10; i++)
        console.log(num, "x", i, "=", num * i);
}

module.exports = {factorial, myprime, printable};