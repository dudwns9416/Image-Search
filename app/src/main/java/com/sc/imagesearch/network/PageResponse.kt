package com.sc.imagesearch.network

import com.google.gson.annotations.SerializedName

data class PageResponse<T>(
    val documents: List<T>,
    val meta: Meta
)

data class Meta(
    @SerializedName("is_end") val isEnd: Boolean = false,
    @SerializedName("pageable_count") val pageableCount: String,
    @SerializedName("total_count") val totalCount: String,
)