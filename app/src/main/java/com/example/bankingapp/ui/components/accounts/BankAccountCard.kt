package com.example.bankingapp.ui.components.accounts

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
fun BankAccountCard(account: BankAccount, isRectangular: Boolean = false) {
    Card(
        modifier = Modifier
            .run {
                if (isRectangular) {
                    this.width(200.dp).height(100.dp) // Dimensions rectangulaires
                } else {
                    this.size(200.dp) // Dimensions carrées
                }
            }
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo de la banque (à remplacer par une vraie implémentation de chargement d'image)
            // Pour simplifier, on affiche un texte pour le logo ici
            Text(text = account.logo)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = account.name)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "${account.balance}€")
        }
    }
}