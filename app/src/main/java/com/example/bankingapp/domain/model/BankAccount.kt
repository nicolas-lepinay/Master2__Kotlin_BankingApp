package com.example.bankingapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class BankAccount(
    val id: Int,
    val name: String,
    val balance: Double,
    val logo: String
)
