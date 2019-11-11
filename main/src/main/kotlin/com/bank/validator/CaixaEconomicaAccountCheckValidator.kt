package com.bank.validator

import com.bank.BankAccount
import java.lang.Integer.parseInt

class CaixaEconomicaAccountCheckValidator : AccountCheckValidator {

    override fun calculateCheckAccount(bankAccount: BankAccount): String {
        val account = StringBuilder(bankAccount.account)
        val pesoBB = "8765432"
        var soma = 0
        val x = pesoBB.length - account.length

        for (j in 0 until x) account.insert(0, "0")

        for (i in pesoBB.indices) {
            if (i >= x) {
                soma += parseInt(pesoBB.substring(i, i + 1)) * parseInt(account.substring(i, i + 1))
            }
        }

        return module(soma)
    }

    private fun module(sumSeq: Int) =
        when (val result = 11 - sumSeq % 11) {
            10 -> "0"
            11 -> "0"
            else -> result.toString()
        }
}