package com.sc.imagesearch.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.domain.usecase.GetImagesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val getImagesUseCase: GetImagesUseCase) : ViewModel() {

    private val _images: MutableLiveData<List<Image>> = MutableLiveData()
    val images: LiveData<List<Image>>
        get() = _images

    fun loadImages() {
        getImagesUseCase.invoke("강아지")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    _images.value = it.documents
                },
                {
                    Log.e("RxFailEvent","${it.message}")
                }
            )

    }
}