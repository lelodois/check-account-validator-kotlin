package com.bank

class BankAccount(
    val bankCode: String,
    val agency: String,
    val account: String,
    val accountCheck: String
) {

    override fun toString() =
        String.format("%s[%s %s-%s]", bankCode, agency, account, accountCheck)
}