package com.example.bankingapp.ui.components.accounts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bankingapp.domain.model.BankAccount
import com.example.bankingapp.domain.model.withAddAccount
import com.example.bankingapp.viewmodel.BankAccountViewModel
import com.example.bankingapp.ui.theme.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.bankingapp.R

@Composable
fun BankAccountsSheet(viewModel: BankAccountViewModel = hiltViewModel()) {
    val accountsOriginal by viewModel.accounts.collectAsState()
    val accounts = remember { mutableStateListOf(*accountsOriginal.withAddAccount().toTypedArray()) }
    val columns = prepareColumns(accounts)

    Column(
        modifier = Modifier
            .padding(start = 36.dp)
    ) {
        Text(
            text = stringResource(R.string.my_accounts).uppercase(),
            style = customHeadlineLarge,
            color = Darker,
            modifier = Modifier.padding(bottom = 28.dp)
        )

        if (accountsOriginal.isEmpty()) {
            Text(
                text = stringResource(R.string.no_bank_account),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item { AddAccountCard(isRectangular = true) }
            }

        } else {
            LazyRow(
                contentPadding = PaddingValues(end = 18.dp, bottom = 32.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(count = columns.size) { index ->
                    val columnType = columns[index]
                    when (columnType) {
                        is ColumnType.Square -> {
                            if (columnType.account.id == -1) {
                                AddAccountCard(isRectangular = false)
                            } else {
                                BankAccountCard(account = columnType.account)
                            }
                        }
                        is ColumnType.Rectangular -> {
                            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                                if (columnType.account1.id == -1) {
                                    AddAccountCard(isRectangular = true)
                                } else {
                                    BankAccountCard(account = columnType.account1, color = Color.Black, isRectangular = true)
                                }
                                columnType.account2?.let { account2 ->
                                    if (account2.id == -1) {
                                        AddAccountCard(isRectangular = true)
                                    } else {
                                        BankAccountCard(account = account2, color = ColorSurface, isRectangular = true)
                                    }
                                }
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
}

fun prepareColumns(accounts: List<BankAccount>): List<ColumnType> { // Modified prepareColumns
    val columns = mutableListOf<ColumnType>()
    var accountIndex = 0
    val accountCount = accounts.size

    while (accountIndex < accountCount) {
        val account = accounts[accountIndex]

        if (accountIndex % 3 == 0) { // Square column
            columns.add(ColumnType.Square(account))
            accountIndex += 1
        } else { // Rectangular column
            val account2 = if (accountIndex + 1 < accountCount) { // Simple check for account2
                accounts[accountIndex + 1]
            } else {
                null
            }
            columns.add(ColumnType.Rectangular(account, account2))
            accountIndex += if (account2 != null) 2 else 1
        }
    }
    return columns
}