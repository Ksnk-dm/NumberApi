package com.ksnk.numbers.ui.homeFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ksnk.numbers.api.NumberApi
import com.ksnk.numbers.data.entity.NumbersEntity
import com.ksnk.numbers.data.repository.NumbersRepository
import com.ksnk.numbers.di.App
import com.ksnk.numbers.utils.showToast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class HomeViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var apiInterface: NumberApi

    @Inject
    lateinit var repository: NumbersRepository

    private var myCompositeDisposable: CompositeDisposable? = null

    init {
        (application as App).getAppComponent().inject(this)
        myCompositeDisposable = CompositeDisposable()
    }

    fun retroFitResponseSearch(query: String) {
        myCompositeDisposable?.add(
            apiInterface.getSearchNumber(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::onResponse, this::onFailure)
        )
    }

    fun getRandomNumber() {
        myCompositeDisposable?.add(
            apiInterface.getRandomNumber()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::onResponse, this::onFailure)
        )
    }

    fun insert(numbersEntity: NumbersEntity) {
        repository.insert(numbersEntity)
    }

    private fun onFailure(t: Throwable) {
        showToast(t.toString())
    }

    private fun onResponse(response: NumbersEntity) {
        insert(response)
    }

    fun getAll(): LiveData<List<NumbersEntity>>? = repository.getAll()

}
