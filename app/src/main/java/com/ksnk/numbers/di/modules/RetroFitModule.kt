package com.ksnk.numbers.di.modules

import com.ksnk.numbers.api.NumberApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetroFitModule {
    private val baseURL = "http://numbersapi.com/"
    @Singleton
    @Provides
    fun getRetroServiceInterface(retrofit: Retrofit): NumberApi {
        return retrofit.create(NumberApi::class.java)
    }

    @Singleton
    @Provides
    fun getRetroFitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}