package com.sc.imagesearch.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.domain.usecase.GetImagePagingSourceUseCase
import com.sc.imagesearch.extensions.add
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.TimeUnit


class MainViewModel(
    private val getImagePagingSourceUseCase: GetImagePagingSourceUseCase
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val subject = PublishSubject.create<String>()

    private val _pages: MutableLiveData<Flow<PagingData<Image>>> = MutableLiveData()
    val pages: LiveData<Flow<PagingData<Image>>>
        get() = _pages

    fun searchImagesByKeyword(query: String) {
        subject.onNext(query)
    }

    fun fetchImagesWithPage() {
        subject.debounce(SECOND, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .filter { it.isNotBlank() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { getImagePages(it) },
                { Log.e("RxFailEvent", "${it.message}") }
            ).add(compositeDisposable)
    }

    private fun getImagePages(query: String) {
        _pages.value = getImagePagingSourceUseCase.invoke(query)
            .cachedIn(viewModelScope)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    companion object {
        private const val SECOND: Long = 1000
    }
}