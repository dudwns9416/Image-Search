package com.sc.imagesearch.data.repository

import com.sc.imagesearch.data.network.ImageSearchService
import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.network.PageResponse
import com.sc.imagesearch.domain.repository.ImageRepository
import io.reactivex.Observable

class ImageRepositoryImpl(
    private val imageSearchService: ImageSearchService
) : ImageRepository {

    override fun findImages(query: String): Observable<PageResponse<Image>> {
        return imageSearchService.findImages(query)
    }
}