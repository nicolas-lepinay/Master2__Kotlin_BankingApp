package com.example.bankingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults.DragHandle
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.bankingapp.ui.components.balance.BalanceSheet
import com.example.bankingapp.ui.components.accounts.BankAccountsSheet
import com.example.bankingapp.ui.components.transactions.TransactionsSheet
import com.example.bankingapp.ui.theme.BankingAppTheme
import com.example.bankingapp.ui.theme.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankingAppTheme {
                BankingHomeScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BankingHomeScreen() {
    val balanceSheetState = rememberBottomSheetScaffoldState()
    val transactionSheetState = rememberBottomSheetScaffoldState()
    val bankAccountsSheetState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = bankAccountsSheetState,
        sheetContent = { BankAccountsSheet() },
        sheetPeekHeight = 120.dp,
        sheetSwipeEnabled = true,
        sheetContainerColor = Color.White,
        sheetShape = RoundedCornerShape(
            topStart = 64.dp,
            topEnd = 64.dp
        ),
        sheetDragHandle = {
            DragHandle(
                color = Darker
            )
        },
    ) { bankAccountsPadding ->
        BottomSheetScaffold(
            scaffoldState = transactionSheetState,
            sheetContent = { TransactionsSheet() },
            sheetPeekHeight = 530.dp,
            sheetSwipeEnabled = true,
            sheetContainerColor = ColorSurface,
            sheetShape = RoundedCornerShape(
                topStart = 64.dp,
                topEnd = 64.dp
            ),
            sheetDragHandle = {
                DragHandle(
                    color = Color.White
                )
            },
        ) { transactionPadding ->

            BottomSheetScaffold(
                scaffoldState = balanceSheetState,
                sheetContent = { BalanceSheet() },
                sheetPeekHeight = 710.dp,
                sheetSwipeEnabled = true,
                sheetContainerColor = Color.Black,
                sheetShape = RoundedCornerShape(
                    topStart = 64.dp,
                    topEnd = 64.dp
                ),
                sheetDragHandle = {
                    DragHandle(
                        color = Color.White
                    )
                },
            ) { accountPadding ->

                Column(
                    modifier = Modifier
                        .background(color = Color.White)
                        .padding(accountPadding)
                        .fillMaxSize()

                ) {
                    Text(
                        text = stringResource(R.string.greetings),
                        style = MaterialTheme.typography.titleLarge,
                        color = Darkest,
                        modifier = Modifier.padding(start = 32.dp, top = 26.dp)
                    )
                }
            }
        }
    }
}