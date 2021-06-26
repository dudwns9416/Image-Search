package com.sc.imagesearch.data.network

import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.network.PageResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageSearchService {

    @GET("/v2/search/image")
    fun findImages(
        @Query("query") query: String,
        @Query("page") page: Int? = null,
        @Query("size") size: Int? = null,
    ): Single<PageResponse<Image>>
}