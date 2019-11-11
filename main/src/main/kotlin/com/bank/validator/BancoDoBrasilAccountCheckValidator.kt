package com.bank.validator

import com.bank.BankAccount

class BancoDoBrasilAccountCheckValidator : AccountCheckValidator {

    override fun calculateCheckAccount(bankAccount: BankAccount): String {
        val accountNumber = StringBuilder(bankAccount.account)
        val pesoBB = "98765432"
        var soma = 0
        val x = pesoBB.length - accountNumber.length

        for (j in 0 until x) accountNumber.insert(0, "0")

        for (i in pesoBB.indices)
            if (i >= x)
                soma += Integer.parseInt(pesoBB.substring(i, i + 1)) * Integer
                    .parseInt(accountNumber.substring(i, i + 1))

        return module(soma)
    }

    private fun module(sumSeq: Int): String =
        when (val result = 11 - sumSeq % 11) {
            10 -> "X"
            11 -> "0"
            else -> result.toString()
        }
}