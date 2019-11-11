package com.bank.validator

import com.bank.BankAccount

class BanrisulAccountCheckValidator : AccountCheckValidator {

    override fun calculateCheckAccount(bankAccount: BankAccount): String {
        val numbers = bankAccount.account.toCharArray()
        var sumSeq = 0

        for (i in numbers.indices) {
            val number = numbers[i].toInt()
            sumSeq += multiplyAccordingWeight(number, i)
        }

        return module11(sumSeq).toString()
    }

    private fun multiplyAccordingWeight(number: Int, index: Int): Int {
        val weight = intArrayOf(3, 2, 4, 7, 6, 5, 4, 3, 2)
        return number * weight[index]
    }

    private fun module11(sumSeq: Int) =
        when (val module = sumSeq % 11) {
            0 -> 0
            1 -> 6
            else -> 11 - module
        }
}