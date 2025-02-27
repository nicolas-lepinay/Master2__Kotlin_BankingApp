package com.example.bankingapp.ui.components.accounts_v1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bankingapp.domain.model.BankAccount
import com.example.bankingapp.ui.theme.ColorSurface

@Composable
fun SquareAccountCard(
    modifier: Modifier,
    account: BankAccount,
    columnIndex: Int
) {
    Card(
        modifier = modifier.height(150.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = ColorSurface
        )
    ) {
        // Contenu
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp))
            )
            // Titre "Solde"
            Text("Solde", style = MaterialTheme.typography.bodyMedium)
            // Montant
            Text(
                String.format("%.2f€", account.balance),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

