package com.example.bankingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.example.bankingapp.ui.components.AccountSheet
import com.example.bankingapp.ui.components.TransactionsSheet
import com.example.bankingapp.ui.theme.BankingAppTheme
import com.example.bankingapp.ui.theme.DarkestGrey
import com.example.bankingapp.ui.theme.Lavender
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
    val accountSheetState = rememberBottomSheetScaffoldState()
    val transactionSheetState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = transactionSheetState,
        sheetContent = { TransactionsSheet() },
        sheetPeekHeight = 600.dp,
        sheetSwipeEnabled = true,
    ) { transactionPadding ->

        BottomSheetScaffold(
            scaffoldState = accountSheetState,
            sheetContent = { AccountSheet() },
            sheetPeekHeight = 800.dp,
            ) { accountPadding ->

            Column(
                modifier = Modifier
                    .padding(accountPadding)
                    .fillMaxSize()
            ) {
                Text(
                    text = stringResource(R.string.greetings),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(start = 32.dp, top = 64.dp)
                )
            }
        }
    }
}