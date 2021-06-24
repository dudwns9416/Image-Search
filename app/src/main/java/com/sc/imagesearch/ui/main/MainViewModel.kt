package com.sc.imagesearch.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sc.imagesearch.domain.model.Image

class MainViewModel : ViewModel() {

    private val _images: MutableLiveData<List<Image>> = MutableLiveData()
    val images: LiveData<List<Image>>
        get() = _images

    fun loadImages() {
        _images.value = arrayListOf(
            Image(imageUrl = "https://t1.daumcdn.net/cafeattach/172cb/0e51b0b07bf4ac7171b6826bba608ca4a63ecc83"),
            Image(imageUrl = "https://t1.daumcdn.net/cafeattach/172cb/0e51b0b07bf4ac7171b6826bba608ca4a63ecc83"),
            Image(imageUrl = "https://t1.daumcdn.net/cafeattach/172cb/0e51b0b07bf4ac7171b6826bba608ca4a63ecc83"),
            Image(imageUrl = "https://t1.daumcdn.net/cafeattach/172cb/0e51b0b07bf4ac7171b6826bba608ca4a63ecc83"),
            Image(imageUrl = "https://t1.daumcdn.net/cafeattach/172cb/0e51b0b07bf4ac7171b6826bba608ca4a63ecc83"),
            Image(imageUrl = "https://t1.daumcdn.net/cafeattach/172cb/0e51b0b07bf4ac7171b6826bba608ca4a63ecc83"),
        )
    }
}