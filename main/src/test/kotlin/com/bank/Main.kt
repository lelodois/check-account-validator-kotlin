package com.bank

import com.bank.validator.AccountCheckValidator
import com.bank.validator.BancoDoBrasilAccountCheckValidator
import com.bank.validator.BanrisulAccountCheckValidator
import com.bank.validator.BradescoAccountCheckValidator
import com.bank.validator.CaixaEconomicaAccountCheckValidator
import com.bank.validator.ItauAccountCheckValidator
import java.util.HashMap

class Main {

    private fun validator(bankNumber: String): AccountCheckValidator {

        val validators = HashMap<String, AccountCheckValidator>()
        validators["001"] = BancoDoBrasilAccountCheckValidator()
        validators["041"] = BanrisulAccountCheckValidator()
        validators["237"] = BradescoAccountCheckValidator()
        validators["341"] = ItauAccountCheckValidator()
        validators["104"] = CaixaEconomicaAccountCheckValidator()

        if (!validators.containsKey(bankNumber)) {
            throw RuntimeException("bankCode not found")
        }

        return validators[bankNumber]!!
    }


    fun validate(vararg contas: BankAccount) {
        for (conta in contas)
            println(this.validator(conta.bankCode).validate(conta).toString() + " " + conta)
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            Main().validate(
                BankAccount("341", "7657", "09210", "7"),
                BankAccount("341", "7131", "12158", "9"),
                BankAccount("341", "7191", "07084", "1"),
                BankAccount("341", "2545", "02366", "1"),
                BankAccount("341", "1874", "10009", "0"),
                BankAccount("237", "1584", "0210169", "6"),
                BankAccount("001", "0021", "53375", "0"),
                BankAccount("001", "1584", "00210169", "6")
            )
        }
    }
}