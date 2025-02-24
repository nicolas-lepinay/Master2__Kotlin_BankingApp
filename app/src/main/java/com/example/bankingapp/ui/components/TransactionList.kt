package com.example.bankingapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bankingapp.domain.model.Transaction
import com.example.bankingapp.viewmodel.TransactionViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TransactionsSheet(viewModel: TransactionViewModel = hiltViewModel()) {
    val transactions by viewModel.transactions.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        items(transactions) { transaction ->
            TransactionItem(transaction)
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = transaction.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${transaction.amount}€",
                color = if (transaction.amount < 0) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
            )
            Text(text = transaction.date, style = MaterialTheme.typography.bodySmall)
        }
    }
}
