package com.example.bankingapp.ui.components.accounts_v1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dashedBorder

@Composable
fun EmptyAccountCard(modifier: Modifier, isSquare: Boolean) {
    val height = if (isSquare) 150.dp else 120.dp
    Box(
        modifier = modifier
            .height(height)
            .dashedBorder(
                strokeWidth = 2.dp,
                cornerRadius = 16.dp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                intervals = floatArrayOf(10f, 10f)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "+",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

