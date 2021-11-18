function getGreeting(hrs) {
    if (hrs >= 6 && hrs < 12) {
        return "Good Morning";
    } else if (hrs >= 12 && hrs < 16) {
        return "Good Afternoon";
    } else {
        return "Good Evening";
    }
}

exports.greet = () => {
    var date  = new Date();

    return getGreeting(date.getHours());
}
