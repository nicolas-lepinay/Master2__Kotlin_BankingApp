package com.example.bankingapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankingapp.data.repository.BankAccountRepository
import com.example.bankingapp.domain.model.BankAccount
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BankAccountViewModel @Inject constructor(
    @ApplicationContext context: Context
) : ViewModel() {

    private val repository = BankAccountRepository(context)

    private val _accounts = MutableStateFlow<List<BankAccount>>(emptyList())
    val accounts: StateFlow<List<BankAccount>> = _accounts

    init {
        loadBankAccounts()
    }

    private fun loadBankAccounts() {
        viewModelScope.launch {
            _accounts.value = repository.getBankAccounts()
        }
    }
}
