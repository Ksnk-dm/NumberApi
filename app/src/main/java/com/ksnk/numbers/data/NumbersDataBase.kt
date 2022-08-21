package com.ksnk.numbers.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ksnk.numbers.data.dao.NumbersDao
import com.ksnk.numbers.data.entity.NumbersEntity


@Database(entities = [NumbersEntity::class], version = 1)
abstract class NumbersDataBase : RoomDatabase() {
    abstract fun numbersDao(): NumbersDao

    companion object {

        @Volatile
        private var instance: NumbersDataBase? = null

        private val LOCK = Any()

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NumbersDataBase::class.java,
                "db"
            ).allowMainThreadQueries().build()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }
    }
}