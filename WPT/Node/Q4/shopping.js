function calculateDiscount(purchaseAmount) {
    switch (true) {
        case (purchaseAmount < 2500):
            return 0;
        case (purchaseAmount <= 5000):
            return 10;
        case (purchaseAmount > 5000):
            return 20;
    }
}

function calculateGST(purchaseAmount) {
    // 18% GST
    return Math.round(purchaseAmount * 0.18)
}

module.exports = {calculateDiscount, calculateGST};