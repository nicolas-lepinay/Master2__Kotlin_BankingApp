package com.example.bankingapp.ui.components.accounts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.ui.theme.*
import dashedBorder

@Composable
fun AddAccountCard(isRectangular: Boolean = false) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .run {
                if (isRectangular) {
                    this.width(178.dp).height(80.dp) // Dimensions rectangulaires
                } else {
                    this.size(178.dp) // Dimensions carrées par défaut
                }
            }
            .fillMaxSize()
            .dashedBorder(strokeWidth = 2.dp, color = Light, cornerRadius = 26.dp)
    ) {
        Text(
            text = "+",
            fontSize = 40.sp,
            color = Light
        )
    }
}