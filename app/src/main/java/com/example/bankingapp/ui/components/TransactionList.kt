
package com.example.bankingapp.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import com.example.bankingapp.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.bankingapp.domain.model.Transaction
import com.example.bankingapp.viewmodel.TransactionViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bankingapp.ui.theme.customHeadlineLargeItalic

@Composable
fun TransactionsSheet(viewModel: TransactionViewModel = hiltViewModel()) {
    val transactions by viewModel.transactions.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 36.dp)
    ) {
        // Title
        Text(
            text = stringResource(R.string.transactions).uppercase(),
            style = customHeadlineLargeItalic,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        // List of transactions
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 64.dp)
        ) {
            items(transactions) { transaction ->
                TransactionItem(transaction)
            }
        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun TransactionItem(transaction: Transaction) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Container arrondi pour l'icône
        Box(
            modifier = Modifier
                .size(52.dp)
                .background(Color.Black.copy(alpha = 0.05f), shape = RoundedCornerShape(20.dp))
                .padding(14.dp)
        ) {
            Icon(
                imageVector = getTransactionIcon(transaction.category),
                contentDescription = "Transaction Icon",
                tint = Color.White,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Informations principales (titre + type)
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            Text(
                text = transaction.title,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
            Text(
                text = transaction.type.uppercase(),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.6f)
            )
        }

        // Montant aligné à droite
        Text(
            text = String.format("%s%.2f€", if (transaction.amount > 0) "+" else "", transaction.amount),
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
    }
}


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
