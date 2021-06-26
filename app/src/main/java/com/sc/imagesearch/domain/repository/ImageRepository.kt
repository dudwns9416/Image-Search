package com.sc.imagesearch.domain.repository

import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.network.PageResponse
import io.reactivex.Observable
import io.reactivex.Single

interface ImageRepository {
    fun findImages(query: String): Observable<PageResponse<Image>>
    fun findImagesWithPage(query: String, page: Int, size: Int): Single<PageResponse<Image>>
}