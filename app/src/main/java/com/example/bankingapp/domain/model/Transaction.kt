package com.example.bankingapp.domain.model

import kotlinx.serialization.Serializable
import com.example.bankingapp.R
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

@Serializable
data class Transaction(
    val id: Int,
    val title: String,
    val amount: Double,
    val date: String,
    val category: String,
    val type: String
)

@Composable
fun getTransactionIcon(category: String): ImageVector {
    return when (category.lowercase()) {
        "makeup" -> ImageVector.vectorResource(R.drawable.lips)
        "book" -> ImageVector.vectorResource(R.drawable.book)
        "salary" -> ImageVector.vectorResource(R.drawable.wallet)
        "trip" -> ImageVector.vectorResource(R.drawable.plane)
        "animal" -> ImageVector.vectorResource(R.drawable.cat)
        "transport" -> ImageVector.vectorResource(R.drawable.bus)
        "doctor" -> ImageVector.vectorResource(R.drawable.facemask)
        "game" -> ImageVector.vectorResource(R.drawable.gamepad)
        "gas" -> ImageVector.vectorResource(R.drawable.gas)
        "clothes" -> ImageVector.vectorResource(R.drawable.shirt)
        "shoe" -> ImageVector.vectorResource(R.drawable.shoe)
        "haircut" -> ImageVector.vectorResource(R.drawable.scissors)
        "theater" -> ImageVector.vectorResource(R.drawable.theater)
        else -> ImageVector.vectorResource(R.drawable.wallet)
    }
}