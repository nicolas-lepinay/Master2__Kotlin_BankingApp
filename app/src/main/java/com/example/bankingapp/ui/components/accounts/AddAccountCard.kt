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
import androidx.compose.ui.unit.sp
import com.example.bankingapp.domain.model.BankAccount
import com.example.bankingapp.ui.theme.ColorSurface
import dashedBorder

@Composable
fun AddAccountCard(isRectangular: Boolean = false) {
    Card(
        modifier = Modifier
            .run {
                if (isRectangular) {
                    this.width(200.dp).height(100.dp) // Dimensions rectangulaires
                } else {
                    this.size(200.dp) // Dimensions carrées par défaut
                }
            }
            .padding(8.dp)
            .dashedBorder(strokeWidth = 2.dp, color = Color.Gray, cornerRadius = 8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "+",
                fontSize = 40.sp,
                color = Color.Gray
            )
        }
    }
}