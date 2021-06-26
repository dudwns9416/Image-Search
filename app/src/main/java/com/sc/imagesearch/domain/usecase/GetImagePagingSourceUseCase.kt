package com.sc.imagesearch.domain.usecase

import androidx.paging.PagingData
import com.sc.imagesearch.domain.model.Image
import io.reactivex.Observable

interface GetImagePagingSourceUseCase {

    fun invoke(query: String): Observable<PagingData<Image>>
}