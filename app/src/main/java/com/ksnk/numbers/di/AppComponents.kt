package com.ksnk.numbers.di

import android.content.Context
import com.ksnk.numbers.di.modules.DataBaseModule
import com.ksnk.numbers.di.modules.RetroFitModule
import com.ksnk.numbers.ui.homeFragment.HomeViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RetroFitModule::class, DataBaseModule::class]
)

interface AppComponent {
    fun inject(mainActivityViewModel: HomeViewModel)
    fun database(context: Context)
}