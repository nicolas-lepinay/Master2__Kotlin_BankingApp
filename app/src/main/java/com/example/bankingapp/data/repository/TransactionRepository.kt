package com.example.bankingapp.data.repository

import android.content.Context
import com.example.bankingapp.domain.model.Transaction
import kotlinx.serialization.json.Json

class TransactionRepository(private val context: Context) {

    fun getTransactions(): List<Transaction> {
        val json = context.assets.open("transactions.json").bufferedReader().use { it.readText() }
        return Json.decodeFromString(json)
    }
}
