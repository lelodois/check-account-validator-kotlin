package com.bank.validator

import com.bank.BankAccount

class BradescoAccountCheckValidator : AccountCheckValidator {

    override fun calculateCheckAccount(bankAccount: BankAccount): String {
        val numbers = bankAccount.account.toCharArray()
        var sumSeq = 0
        for (i in numbers.indices) {
            val number = Integer.parseInt(numbers[i].toString())
            sumSeq += multiplyAccordingWeight(number, i)
        }
        return accountModule(sumSeq)
    }

    private fun multiplyAccordingWeight(number: Int, index: Int) =
        number * intArrayOf(2, 7, 6, 5, 4, 3, 2)[index]

    private fun accountModule(sumSeq: Int) =
        when (val module = sumSeq % 11) {
            0 -> "0"
            else ->
                if (module == 1) "P"
                else (11 - module).toString()
        }
}