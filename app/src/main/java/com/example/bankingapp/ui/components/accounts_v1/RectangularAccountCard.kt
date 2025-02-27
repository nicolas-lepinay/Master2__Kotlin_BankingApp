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
fun RectangularAccountCard(
    modifier: Modifier,
    account: BankAccount,
    columnIndex: Int
) {
    Card(
        modifier = modifier.height(120.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = ColorSurface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp))
            )
            Column {
                Text("Solde", style = MaterialTheme.typography.bodyMedium)
                Text(
                    String.format("%.2f€", account.balance),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

