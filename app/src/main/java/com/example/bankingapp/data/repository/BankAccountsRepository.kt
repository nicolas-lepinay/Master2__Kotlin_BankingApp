package com.example.bankingapp.data.repository

import android.content.Context
import com.example.bankingapp.domain.model.BankAccount
import kotlinx.serialization.json.Json

class BankAccountRepository(private val context: Context) {
    fun getBankAccounts(): List<BankAccount> {
        val json = context.assets.open("bank_accounts.json").bufferedReader().use { it.readText() }
        return Json.decodeFromString(json)
    }
}
