package com.example.bankingapp.ui.components.accounts

import android.util.Log
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
    val (columns, makeAddAccountRectangular) = prepareColumns(accounts)

    Column {
        Text(
            text = "MES COMPTES",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
        )

        if (accounts.isEmpty()) {
            Text(
                text = "Aucun compte bancaire disponible.",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item { AddAccountCard() }
            }

        } else {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(count = columns.size) { index ->
                    val columnType = columns[index]
                    when (columnType) {
                        is ColumnType.Square -> {
                            BankAccountCard(account = columnType.account)
                        }
                        is ColumnType.Rectangular -> {
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                BankAccountCard(account = columnType.account1, isRectangular = true)
                                columnType.account2?.let { account2 ->
                                    BankAccountCard(account = account2, isRectangular = true)
                                }
                                if (makeAddAccountRectangular && columnType.account2 == null) {
                                    AddAccountCard(isRectangular = true) // **Move AddAccountCard here**
                                }
                            }
                        }
                        is ColumnType.AddAccount -> {
                            if (!makeAddAccountRectangular) { // **Only render AddAccountCard in its own column if NOT rectangular**
                                AddAccountCard()
                            }
                        }
                    }
                }
            }
        }
    }
}

sealed class ColumnType {
    data class Square(val account: BankAccount) : ColumnType()
    data class Rectangular(val account1: BankAccount, val account2: BankAccount? = null) : ColumnType()
    object AddAccount : ColumnType()
}


fun prepareColumns(accounts: List<BankAccount>): Pair<List<ColumnType>, Boolean> {
    val columns = mutableListOf<ColumnType>()
    var accountIndex = 0
    val accountCount = accounts.size
    var makeAddAccountRectangular = false

    while (accountIndex < accountCount) {
        if (accountIndex % 3 == 0) {
            columns.add(ColumnType.Square(accounts[accountIndex]))
            accountIndex += 1
        } else {
            val account2 = if (accountIndex + 1 < accountCount && (accountIndex + 1) % 3 != 0) {
                accounts[accountIndex + 1]
            } else {
                null
            }
            columns.add(ColumnType.Rectangular(accounts[accountIndex], account2))
            if (account2 == null && accountIndex == accountCount -1) {
                makeAddAccountRectangular = true
            }
            accountIndex += if (account2 != null) 2 else 1
        }
    }
    columns.add(ColumnType.AddAccount)
    return Pair(columns, makeAddAccountRectangular)
}