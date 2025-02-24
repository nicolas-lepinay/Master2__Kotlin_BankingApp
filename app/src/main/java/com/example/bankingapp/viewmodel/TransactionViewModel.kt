package com.example.bankingapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankingapp.data.repository.TransactionRepository
import com.example.bankingapp.domain.model.Transaction
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    @ApplicationContext context: Context
) : ViewModel() {

    private val repository = TransactionRepository(context)

    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions: StateFlow<List<Transaction>> = _transactions

    init {
        loadTransactions()
    }

    private fun loadTransactions() {
        // Execute l'opération en arrière-plan (co-routine) et ne bloque pas l'app/le main thread
        viewModelScope.launch {
            _transactions.value = repository.getTransactions()
        }
    }
}
