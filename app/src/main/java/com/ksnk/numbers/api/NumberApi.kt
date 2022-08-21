package com.ksnk.numbers.api

import com.ksnk.numbers.data.entity.NumbersEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


interface NumberApi {
    @GET("/{number}/trivia?json")
    fun getSearchNumber(@Path("number") number: String): Observable<NumbersEntity>

    @GET("/random/math?json")
    fun getRandomNumber(): Observable<NumbersEntity>
}