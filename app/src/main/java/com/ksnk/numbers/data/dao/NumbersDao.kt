package com.ksnk.numbers.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ksnk.numbers.data.entity.NumbersEntity

@Dao
interface NumbersDao {
    @Insert
    fun insert(vararg numbersEntity: NumbersEntity)

    @Query("SELECT * FROM numbers")
    fun getAll(): LiveData<List<NumbersEntity>>
}