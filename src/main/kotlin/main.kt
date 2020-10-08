fun main() {



}

fun toFindTheComission (
    previousSummOfPay: Double,
    currentSummOfPay: Double,
    userTypeOfCount: typeOfCount): Double {

    var minComission = 3500.00     // 35 руб.
    var summOfComission = 0.0
    when (userTypeOfCount) {
        typeOfCount.VK_PAY -> summOfComission = 0.0
        typeOfCount.MAESTRO -> {
            if (previousSummOfPay <= 7500000) { //75 т.р.
                summOfComission = 0.0
            } else {
                summOfComission = 0.06 * currentSummOfPay + 2000
            }
        }
        typeOfCount.MASTERCARD -> {
            if (previousSummOfPay <= 7500000) { //75 т.р.
                summOfComission = 0.0
            } else {
                summOfComission = 0.06 * currentSummOfPay + 2000
            }
        }
        typeOfCount.VISA -> {
            if (currentSummOfPay * 0.075 < minComission) {
                summOfComission = minComission
            } else {
                summOfComission = currentSummOfPay * 0.075
            }
        }
        typeOfCount.MIR -> {
            if (currentSummOfPay * 0.075 < minComission) {
                summOfComission = minComission
            } else {
                summOfComission = currentSummOfPay * 0.075
            }
        }
    }
    return summOfComission
}

fun isLimit (
    previousSummOfPay: Double,
    currentSummOfPay: Double,
    userTypeOfCount: typeOfCount): Boolean {

    var isLimit: Boolean = false
    if (((userTypeOfCount == typeOfCount.VK_PAY) && (previousSummOfPay >= 4000000)) ||  // 40 т.р.
        ((userTypeOfCount == typeOfCount.VK_PAY) && (currentSummOfPay >= 1500000))) {   // 15 т.р.
        isLimit = true
    }
    if (((userTypeOfCount == typeOfCount.MAESTRO) ||
                (userTypeOfCount == typeOfCount.VISA) ||
                (userTypeOfCount == typeOfCount.MASTERCARD) ||
                (userTypeOfCount == typeOfCount.MIR)) &&
        (previousSummOfPay >= 60000000))    // 600 т.р.
    {
        isLimit = true
    }
    if (((userTypeOfCount == typeOfCount.MAESTRO) ||
                (userTypeOfCount == typeOfCount.VISA) ||
                (userTypeOfCount == typeOfCount.MASTERCARD) ||
                (userTypeOfCount == typeOfCount.MIR)) &&
        (currentSummOfPay >= 15000000))    // 150 т.р.
    {
        isLimit = true
    }
    return isLimit
}
