package com.example.bankingapp.ui.components.accounts_v1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bankingapp.domain.model.BankAccount
import com.example.bankingapp.viewmodel.BankAccountViewModel

@Composable
fun BankAccountsSheet(viewModel: BankAccountViewModel = hiltViewModel()) {
    val accounts by viewModel.accounts.collectAsState()
    // Ajoute un élément null à la fin pour la case "vide"
    val extendedAccounts = accounts.toMutableList<BankAccount?>().apply { add(null) }

    // Transforme la liste en colonnes alternées (Single/Double)
    val columns = createColumns(extendedAccounts)

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "MES COMPTES",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Carousel horizontal
        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(columns.size) { index ->
                val columnItem = columns[index]
                // Affiche chaque colonne
                when (columnItem) {
                    is ColumnItem.Single -> SingleColumnItem(
                        account = columnItem.item,
                        columnIndex = index
                    )
                    is ColumnItem.Double -> DoubleColumnItem(
                        top = columnItem.top,
                        bottom = columnItem.bottom,
                        columnIndex = index
                    )
                }
            }
        }
    }
}

sealed class ColumnItem {
    data class Single(val item: BankAccount?) : ColumnItem()
    data class Double(val top: BankAccount?, val bottom: BankAccount?) : ColumnItem()
}

fun createColumns(accounts: List<BankAccount?>): List<ColumnItem> {
    val columns = mutableListOf<ColumnItem>()
    var i = 0
    while (i < accounts.size) {
        if (i % 2 == 0) {
            // Colonne paire => SINGLE
            // (on récupère 1 item)
            val item = accounts.getOrNull(i)
            columns.add(ColumnItem.Single(item))
            i += 1
        } else {
            // Colonne impaire => DOUBLE
            // (on récupère 2 items si possible)
            val top = accounts.getOrNull(i)
            val bottom = accounts.getOrNull(i + 1)
            columns.add(ColumnItem.Double(top, bottom))
            i += 2
        }
    }
    return columns
}

@Composable
fun SingleColumnItem(
    account: BankAccount?,
    columnIndex: Int
) {
    // Couleur ou style selon index
    // isSquare = true
    // Afficher "carte vide" si account == null
    val modifier = Modifier.width(150.dp) // Largeur fixe si tu veux un carré
    if (account == null) {
        EmptyAccountCard(modifier, isSquare = true)
    } else {
        SquareAccountCard(modifier, account, columnIndex)
    }
}

@Composable
fun DoubleColumnItem(
    top: BankAccount?,
    bottom: BankAccount?,
    columnIndex: Int
) {
    // On affiche 2 Box l’une sur l’autre
    // Largeur ~150.dp, hauteur variable
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        // Premier rectangle
        val topModifier = Modifier.width(150.dp)
        if (top == null) {
            EmptyAccountCard(topModifier, isSquare = false)
        } else {
            RectangularAccountCard(topModifier, top, columnIndex)
        }
        // Deuxième rectangle
        val bottomModifier = Modifier.width(150.dp)
        if (bottom == null) {
            EmptyAccountCard(bottomModifier, isSquare = false)
        } else {
            RectangularAccountCard(bottomModifier, bottom, columnIndex)
        }
    }
}

