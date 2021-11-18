function palindrome(string) {
    string = string.toLowerCase();
    
    if (string === string.split("").reverse().join(""))
        return true;
    return false;
}

function upper(string) {
    return string.toUpperCase();
}

function search() {
    let count = 0;

    for (const str of arguments) {
        if (/^(www)+/.test(str))
            count++;
    }

    console.log("Count of sites starting with `www`", count);
}

module.exports = {palindrome, upper, search}