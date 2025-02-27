package com.example.bankingapp.ui.components.accounts_v1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.stringResource
import com.example.bankingapp.R
import com.example.bankingapp.domain.model.BankAccount

@Composable
fun FilledAccountCard(
    width: Dp,
    height: Dp,
    backgroundColor: Color,
    account: BankAccount,
    isSquare: Boolean
) {
    // Si c'est carré => arrangement vertical, sinon horizontal
    if (isSquare) {
        // Arrangement vertical (Column)
        Column(
            modifier = Modifier
                .size(width, height)
                .background(backgroundColor, shape = RoundedCornerShape(16.dp))
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp)) // ex. un conteneur arrondi
            )
            // "Solde"
            Text(
                text = stringResource(R.string.balance),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            // Montant
            Text(
                text = String.format("%.2f€", account.balance),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    } else {
        // Arrangement horizontal (Row)
        Row(
            modifier = Modifier
                .size(width, height)
                .background(backgroundColor, shape = RoundedCornerShape(16.dp))
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Logo
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp)) // ex. un conteneur arrondi
            )
            // Colonne avec "Solde" + Montant
            Column {
                Text(
                    text = stringResource(R.string.balance),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
                Text(
                    text = String.format("%.2f€", account.balance),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }
        }
    }
}
