package com.sc.imagesearch.domain.usecase

import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.network.PageResponse
import io.reactivex.Observable

interface GetImagesUseCase {
    fun invoke(query: String): Observable<PageResponse<Image>>
}