package com.example.expanse.data

import android.app.Application
import androidx.lifecycle.LiveData

class TransactionListRepository( context: Application){
    private val transactionDao: TransactionDao =TransactionDatabase.getDatabase(context).transactionDao()

    fun getTransactions(): LiveData<List<Transaction>> {
        return transactionDao.getAllTransaction()
    }

    fun getAmount(): LiveData<Float> {
        return transactionDao.getAmount()
    }

    fun getTransactionByDate(date: String): LiveData<List<Transaction>> {
        return transactionDao.getTransactionByDate(date)
    }

    fun getAmountCash(): LiveData<Float> {
        return transactionDao.getSumCash()
    }

    fun getAmountCredit(): LiveData<Float> {
        return transactionDao.getSumCredit()
    }

    fun getAmountDebit(): LiveData<Float> {
        return transactionDao.getSumDebit()
    }



    fun getTransactionMonth(monthYear: Long): LiveData<List<Transaction>> {
        return transactionDao.getTransactionMonth(monthYear)
    }

    fun getSumMonth(monthYear: Long): LiveData<Float> {
        return transactionDao.getSumMonth(monthYear)
    }


}