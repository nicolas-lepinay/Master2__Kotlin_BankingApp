package com.example.bankingapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bankingapp.ui.theme.*

@Composable
fun AccountSheet() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkestGrey)
            .padding(16.dp)
    ) {
        Text(
            text = "💰 Solde Total",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "2 500,00€",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Mois en cours : +300,00€",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(500.dp))
    }
}
