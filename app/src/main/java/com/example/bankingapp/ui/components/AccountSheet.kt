package com.example.bankingapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.bankingapp.R
import com.example.bankingapp.ui.theme.*

@Composable
fun AccountSheet() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Titre "SOLDE TOTAL"
        Text(
            text = stringResource(R.string.total_balance).uppercase(),
            style = customTitleMedium,
            color = Color.White.copy(alpha = 0.8f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Montant du solde
        Text(
            text = "1 017.30€",
            style = displayMediumBold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(48.dp))

        // Container arrondi "Solde pointé"
        BalancePill(
            checked = true,
            label = stringResource(R.string.checked_balance),
            balance = "819.70€"
        )

    }
}

