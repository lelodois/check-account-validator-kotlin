package com.bank.validator

import com.bank.BankAccount

interface AccountCheckValidator {

    fun validate(bankAccount: BankAccount) =
        bankAccount.accountCheck == this.calculateCheckAccount(bankAccount)

    fun calculateCheckAccount(bankAccount: BankAccount): String
}