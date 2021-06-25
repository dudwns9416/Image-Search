package com.sc.imagesearch.data.network

import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.network.PageResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageSearchService {

    @GET("/v2/search/image")
    fun findImages(
        @Query("query") query: String,
    ): Observable<PageResponse<Image>>
}