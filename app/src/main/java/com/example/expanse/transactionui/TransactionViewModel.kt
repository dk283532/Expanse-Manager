package com.example.expanse.transactionui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.expanse.data.Transaction
import com.example.expanse.data.TransactionListRepository

class TransactionViewModel(application: Application):AndroidViewModel(application) {
    private val repo:TransactionListRepository = TransactionListRepository(application)

    val tranaction:LiveData<List<Transaction>>
        get() = repo.getTransactions()

    val netAmount: LiveData<Float>
        get() = repo.getAmount()

    val netAmountCash: LiveData<Float>
        get() = repo.getAmountCash()

    val netAmountCredit: LiveData<Float>
        get() = repo.getAmountCredit()

    val netAmountDebit: LiveData<Float>
        get() = repo.getAmountDebit()

}