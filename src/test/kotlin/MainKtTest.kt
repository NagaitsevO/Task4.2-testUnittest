import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun main_VK_PAY() {
        var userTypeOfCount = typeOfCount.VK_PAY
        var previousSummOfPay = 0.0
        var currentSummOfPay = 56000.0             //560 руб.

        if (isLimit(previousSummOfPay, currentSummOfPay, userTypeOfCount) == true) {
           } else {
            toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount)
        }
        assertEquals(0.0, toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount) / 100, 0.0)
    }

    @Test
    fun main_MIR_CommonComission() {
        var userTypeOfCount = typeOfCount.MIR
        var previousSummOfPay = 0.0
        var currentSummOfPay = 56000.0             //560 руб.
        if (isLimit(previousSummOfPay, currentSummOfPay, userTypeOfCount) == true) {
            } else {
            toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount)
        }
        assertEquals(42.0, toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount) / 100, 0.0)
    }

    @Test
    fun main_MIR_MinimalComission() {
        var userTypeOfCount = typeOfCount.MIR
        var previousSummOfPay = 0.0
        var currentSummOfPay = 560.0             //5.6 руб.
        if (isLimit(previousSummOfPay, currentSummOfPay, userTypeOfCount) == true) {
            } else {
            toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount)
        }
        assertEquals(35.0, toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount) / 100, 0.0)
    }

    @Test
    fun main_MASTERCARD_outOfLimit() {
        var userTypeOfCount = typeOfCount.MASTERCARD
        var previousSummOfPay = 1111100000.0
        var currentSummOfPay = 7800000.0             //78 000 руб.
        if (isLimit(previousSummOfPay, currentSummOfPay, userTypeOfCount) == true) {
            } else {
            toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount)
        }
        assertEquals(true, isLimit(previousSummOfPay, currentSummOfPay, userTypeOfCount))
    }

    @Test
    fun main_MASTERCARD_LittlePreviousSummOfPay() {
        var userTypeOfCount = typeOfCount.MASTERCARD
        var previousSummOfPay = 11000.0
        var currentSummOfPay = 7800000.0             //78 000 руб.
        if (isLimit(previousSummOfPay, currentSummOfPay, userTypeOfCount) == true) {
            } else {
            toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount)
        }
        assertEquals(0.0, toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount) / 100, 0.0)
    }

    @Test
    fun main_MASTERCARD_bigPreviousSummOfPay() {
        var userTypeOfCount = typeOfCount.MASTERCARD
        var previousSummOfPay = 10000000.0
        var currentSummOfPay = 7800000.0             //78 000 руб.
        if (isLimit(previousSummOfPay, currentSummOfPay, userTypeOfCount) == true) {
            } else {
            toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount)
        }
        assertEquals(4700.0, toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount) / 100, 0.0)
    }

    @Test
    fun main_VISA() {
        var userTypeOfCount = typeOfCount.VISA
        var previousSummOfPay = 7800000.0
        var currentSummOfPay = 7800000.0             //78 000 руб.
        if (isLimit(previousSummOfPay, currentSummOfPay, userTypeOfCount) == true) {
            } else {
            toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount)
        }
        assertEquals(5850.0, toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount) / 100, 0.0)
    }

    @Test
    fun main_MAESTRO_outOfLimit() {
        var userTypeOfCount = typeOfCount.MAESTRO
        var previousSummOfPay = 1111100000.0
        var currentSummOfPay = 7800000.0             //78 000 руб.
        if (isLimit(previousSummOfPay, currentSummOfPay, userTypeOfCount) == true) {
            } else {
            toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount)
        }
        assertEquals(false, isLimit(previousSummOfPay, currentSummOfPay, userTypeOfCount))
    }

    @Test
    fun main_MAESTRO_LittlePreviousComission() {
        var userTypeOfCount = typeOfCount.MAESTRO
        var previousSummOfPay = 11000.0
        var currentSummOfPay = 7800000.0             //78 000 руб.
        if (isLimit(previousSummOfPay, currentSummOfPay, userTypeOfCount) == true) {
            } else {
            toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount)
        }
        assertEquals(0.0, toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount) / 100, 0.0)
    }

    @Test
    fun main_MAESTRO_bigPreviousComission() {
        var userTypeOfCount = typeOfCount.MAESTRO
        var previousSummOfPay = 10000000.0
        var currentSummOfPay = 7800000.0             //78 000 руб.
        if (isLimit(previousSummOfPay, currentSummOfPay, userTypeOfCount) == true) {
            } else {
            toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount)
        }
        assertEquals(4700.0, toFindTheComission(previousSummOfPay, currentSummOfPay, userTypeOfCount) / 100, 0.0)
    }
}