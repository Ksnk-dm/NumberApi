package com.ksnk.numbers.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

@Entity(tableName = "numbers")
data class NumbersEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "text")
    @SerializedName("text")
    val text: String,
    @SerializedName("number")
    @ColumnInfo(name = "number")
    val number: String,
) : Serializable