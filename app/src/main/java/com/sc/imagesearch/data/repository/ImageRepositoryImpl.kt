package com.sc.imagesearch.data.repository

import com.sc.imagesearch.data.network.ImageSearchService
import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.domain.repository.ImageRepository
import com.sc.imagesearch.network.PageResponse
import io.reactivex.Observable
import io.reactivex.Single

class ImageRepositoryImpl(
    private val imageSearchService: ImageSearchService
) : ImageRepository {

    override fun findImages(query: String): Observable<PageResponse<Image>> {
        return imageSearchService.findImages(query).toObservable()
    }

    override fun findImagesWithPage(
        query: String,
        page: Int,
        size: Int
    ): Single<PageResponse<Image>> {
        return imageSearchService.findImages(query, page, size)
    }
}