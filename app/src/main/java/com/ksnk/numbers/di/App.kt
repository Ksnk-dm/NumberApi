package com.ksnk.numbers.di

import android.app.Application
import com.ksnk.numbers.di.modules.DataBaseModule
import com.ksnk.numbers.di.modules.RetroFitModule

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .retroFitModule(RetroFitModule())
            .dataBaseModule(DataBaseModule(this))
            .build()
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }}