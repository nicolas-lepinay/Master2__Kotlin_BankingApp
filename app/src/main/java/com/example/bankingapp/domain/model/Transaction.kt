package com.example.bankingapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Transaction(
    val id: Int,
    val title: String,
    val amount: Double,
    val date: String,
    val category: String,
    val type: String
)