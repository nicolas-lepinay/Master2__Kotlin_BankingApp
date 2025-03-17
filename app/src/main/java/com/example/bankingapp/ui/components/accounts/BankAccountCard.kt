package com.example.bankingapp.ui.components.accounts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bankingapp.domain.model.BankAccount
import com.example.bankingapp.domain.model.getAccountIcon
import com.example.bankingapp.ui.theme.*
import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun BankAccountCard(
    account: BankAccount,
    color: Color = ColorSurface2,
    isRectangular: Boolean = false
) {
    Card(
        modifier = Modifier
            .run {
                if (isRectangular) {
                    this.width(180.dp).height(82.dp) // Dimensions rectangulaires
                } else {
                    this.size(180.dp) // Dimensions carrées
                }
            },
        shape = if (isRectangular) RoundedCornerShape(24.dp) else RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = color,
            contentColor = if (color == ColorSurface2) Darkest else Color.White
        )
        ) {
        if (isRectangular)
            Row(
                modifier = Modifier
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Container arrondi pour l'icône
                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .background(Color.Black.copy(alpha = 0.05f), shape = RoundedCornerShape(20.dp))
                        .padding(14.dp)
                ) {
                    Image(
                        painter = getAccountIcon(account.name),
                        contentDescription = "Account Icon",
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "${"%.2f".format(account.balance)}€", fontSize = 20.sp)
                /*
                Column() {
                    Text(text = account.name, fontWeight = FontWeight.Bold)
                    Text(text = "${account.balance}€")
                }
                 */
            }
        else {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(75.dp)
                        .background(Color.Black.copy(alpha = 0.05f), shape = RoundedCornerShape(20.dp))
                        .padding(14.dp)
                ) {
                    Image(
                        painter = getAccountIcon(account.name),
                        contentDescription = "Account Icon",
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                //Text(text = account.name, fontWeight = FontWeight.Bold)
                Text(text = "${"%.2f".format(account.balance)}€", fontSize = 20.sp)
            }
        }
    }
}
