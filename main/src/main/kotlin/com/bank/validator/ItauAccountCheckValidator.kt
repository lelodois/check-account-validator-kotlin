package com.bank.validator

import com.bank.BankAccount

class ItauAccountCheckValidator : AccountCheckValidator {

    override fun calculateCheckAccount(bankAccount: BankAccount): String {
        val numbers = (bankAccount.agency + bankAccount.account).toCharArray()
        var sumSeq = 0
        var sequence: Int
        for (i in numbers.indices) {
            val number = Integer.parseInt(numbers[i].toString())
            sequence = multiplyAccordingParity(number, i)
            sequence = adjustAccordingLength(sequence)
            sumSeq += sequence
        }
        return module(sumSeq)
    }


    private fun multiplyAccordingParity(number: Int, index: Int) =
        number * if (index % 2 == 0) 2 else 1


    private fun adjustAccordingLength(sequence: Int): Int {
        var newSequence = sequence
        if (newSequence > 9) {
            val numbers = newSequence.toString().toCharArray()
            newSequence = 0
            for (number in numbers) {
                newSequence += Integer.parseInt(number.toString())
            }
        }
        return newSequence
    }

    private fun module(sumSeq: Int) =
        when (val module = sumSeq % 10) {
            0 -> "0"
            else -> (10 - module).toString()
        }
}