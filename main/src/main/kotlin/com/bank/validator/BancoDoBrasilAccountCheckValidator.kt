package com.bank.validator

import com.bank.BankAccount
import java.util.stream.IntStream

class BancoDoBrasilAccountCheckValidator : AccountCheckValidator {

    override fun calculateCheckAccount(bankAccount: BankAccount): String {
        val pesoBB = "98765432"
        val accountNumber = String.format("%0${pesoBB.length}d", Integer.parseInt(bankAccount.account))

        return pesoBB.indices
            .map { Integer.parseInt(pesoBB[it].toString()) * Integer.parseInt(accountNumber[it].toString()) }
            .reduce { acc, i -> acc + i }
            .let { module(it) }
    }

    private fun module(sumSeq: Int): String =
        when (val result = 11 - sumSeq % 11) {
            10 -> "X"
            11 -> "0"
            else -> result.toString()
        }
}