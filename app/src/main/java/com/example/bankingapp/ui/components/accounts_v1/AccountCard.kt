package com.example.bankingapp.ui.components.accounts_v1

import androidx.compose.runtime.Composable
import com.example.bankingapp.domain.model.BankAccount

@Composable
fun AccountCard(
    account: BankAccount?,
    isSquare: Boolean,
    overallIndex: Int
) {
    /*
    // Définir la couleur en fonction de l'index (par exemple)
    val backgroundColor = if (account != null) {
        when (overallIndex % 3) {
            0 -> ColorSurface2  // Exemple : vert
            1 -> Color.Black // Exemple : noir
            else -> ColorSurface  // Exemple : violet
        }
    } else Color.Transparent

    val modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp)

    if (account == null) {
        EmptyAccountCard(modifier = modifier, isSquare = isSquare)
    } else {
        if (isSquare) {
            SquareAccountCard(account, backgroundColor, modifier)
        } else {
            RectangularAccountCard(account, backgroundColor, modifier)
        }
    }
     */
}

