package com.sc.imagesearch.domain.repository

import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.network.PageResponse
import io.reactivex.Observable

interface ImageRepository {
    fun findImages(query: String): Observable<PageResponse<Image>>
}