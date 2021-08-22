package com.example.expanse.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface  TransactionDao {
     @Query("SELECT * FROM `transaction` WHERE date=:date")
     fun getTransactionByDate(date: String): LiveData<List<Transaction>>


     @Query("SELECT * FROM `transaction` WHERE date>=date('now') order by date ASC")
     fun getAllTransaction():LiveData<List<Transaction>>

    @Query("SELECT Sum(amount) FROM `transaction`")
    fun getAmount(): LiveData<Float>

    @Query("SELECT Sum(amount) FROM `transaction` WHERE type = 0 ")
    fun getSumCash(): LiveData<Float>

    @Query("SELECT Sum(amount) FROM `transaction` WHERE type = 1")
    fun getSumCredit(): LiveData<Float>

    @Query("SELECT Sum(amount) FROM `transaction` WHERE type = 2")
    fun getSumDebit(): LiveData<Float>





    @Query("SELECT * FROM `transaction` WHERE monthYear = :monthYear ORDER BY id")
    fun getTransactionMonth(monthYear: Long): LiveData<List<Transaction>>

    @Query("SELECT SUM(amount) FROM `transaction` WHERE monthYear = :monthYear")
    fun getSumMonth(monthYear: Long): LiveData<Float>

}