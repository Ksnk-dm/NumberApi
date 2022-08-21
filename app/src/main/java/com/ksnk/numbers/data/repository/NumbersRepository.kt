package com.ksnk.numbers.data.repository

import androidx.lifecycle.LiveData
import com.ksnk.numbers.data.NumbersDataBase
import com.ksnk.numbers.data.entity.NumbersEntity
import com.ksnk.numbers.data.dao.NumbersDao
import javax.inject.Inject

class NumbersRepository @Inject constructor(private val db: NumbersDataBase) {
    private var numbersDao: NumbersDao? = db.numbersDao()

    fun insert(numbersEntity: NumbersEntity) = numbersDao?.insert(numbersEntity)

    fun getAll(): LiveData<List<NumbersEntity>>? = numbersDao?.getAll()
}