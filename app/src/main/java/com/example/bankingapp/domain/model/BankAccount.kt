package com.example.bankingapp.domain.model

import kotlinx.serialization.Serializable
import com.example.bankingapp.R
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
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
fun getAccountIcon(name: String): Painter {
    return when (name.lowercase()) {
        "société générale" -> painterResource(R.mipmap.societe_generale_foreground)
        "paypal" -> painterResource(R.mipmap.paypal_foreground)
        "boursobank" -> painterResource(R.mipmap.boursobank_foreground)
        "revolut" -> painterResource(R.mipmap.revolut_foreground)
        "espèces" -> painterResource(R.mipmap.cash_foreground)
        else -> painterResource(R.mipmap.cash_foreground)
    }
}
