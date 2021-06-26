package com.sc.imagesearch.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.domain.usecase.GetImagePagingSourceUseCase
import com.sc.imagesearch.extensions.add
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val getImagePagingSourceUseCase: GetImagePagingSourceUseCase
) : ViewModel() {

    private val _pages: MutableLiveData<PagingData<Image>> = MutableLiveData()
    val pages: LiveData<PagingData<Image>>
        get() = _pages

    private val compositeDisposable = CompositeDisposable()

    fun loadImagesWithPage() {
        getImagePagingSourceUseCase.invoke("강아지")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { _pages.value = it },
                {
                    Log.e("RxFailEvent", "${it.message}")
                }
            ).add(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}