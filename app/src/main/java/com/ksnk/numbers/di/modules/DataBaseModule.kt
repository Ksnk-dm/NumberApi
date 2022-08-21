package com.ksnk.numbers.di.modules

import android.app.Application
import com.ksnk.numbers.data.NumbersDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule(var application: Application?) {
    @Provides
    @Singleton
    fun providesAppDatabase(): NumbersDataBase {
        return NumbersDataBase.buildDatabase(application?.applicationContext!!)
    }
}