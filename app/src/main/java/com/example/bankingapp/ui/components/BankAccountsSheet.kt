package com.example.bankingapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bankingapp.domain.model.BankAccount

@Composable
fun BankAccountsSheet() {
    val accounts = listOf(
        BankAccount("Compte courant", 1_500.0),
        BankAccount("Livret A", 3_200.0),
        BankAccount("Compte épargne", 5_000.0)
    )

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(accounts) { account ->
            BankAccountItem(account)
        }
    }
}

@Composable
fun BankAccountItem(account: BankAccount) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = account.name, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Solde: ${account.balance}€", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
