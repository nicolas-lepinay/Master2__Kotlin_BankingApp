
package com.example.bankingapp.ui.components.transactions

import com.example.bankingapp.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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