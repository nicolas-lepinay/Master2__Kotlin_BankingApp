package com.example.bankingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.ui.components.TransactionsSheet
import com.example.bankingapp.ui.theme.BankingAppTheme
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
    val sheetState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = sheetState,
        sheetContent = {
            TransactionsSheet()
        },
        sheetPeekHeight = 200.dp
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text(
                text = stringResource(R.string.greetings),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

/*
@Composable
fun TransactionsSheet() {
    Column(modifier = Modifier.padding(32.dp)) {
        Text(
            text = "Transactions",
            style = MaterialTheme.typography.titleMedium
        )
        Text(text = "Liste des transactions à venir...")
        Text(text = "Liste des transactions à venir...")
        Text(text = "Liste des transactions à venir...")
        Text(text = "Liste des transactions à venir...")
        Text(text = "Liste des transactions à venir...")
        Text(text = "Liste des transactions à venir...")
        Text(text = "Liste des transactions à venir...")
        Text(text = "Liste des transactions à venir...")
        Text(text = "Liste des transactions à venir...")
        Text(text = "Liste des transactions à venir...")
        Text(text = "Liste des transactions à venir...")
    }
}
 */