package com.example.bankingapp.domain.model

import kotlinx.serialization.Serializable
import com.example.bankingapp.R
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

@Serializable
data class BankAccount(
    val id: Int,
    val name: String,
    val balance: Double,
    val logo: String
)

fun List<BankAccount>.withAddAccount(): List<BankAccount> {
    return this + BankAccount(id = -1, name = "", balance = 0.0, logo = "") // On utilise un ID négatif pour distinguer la carte "Ajouter"
}

@Composable
fun getAccountIcon(name: String): ImageVector {
    return when (name.lowercase()) {
        "société générale" -> ImageVector.vectorResource(R.drawable.lips)
        "paypal" -> ImageVector.vectorResource(R.drawable.book)
        "boursobank" -> ImageVector.vectorResource(R.drawable.wallet)
        "revolut" -> ImageVector.vectorResource(R.drawable.plane)
        "espèces" -> ImageVector.vectorResource(R.drawable.cat)
        else -> ImageVector.vectorResource(R.drawable.wallet)
    }
}
