package com.sc.imagesearch.network

data class PageResponse<T>(
    val documents: List<T>,
    val meta: Meta
)

data class Meta(
    val isEnd: String,
    val pageableCount: String,
    val totalCount: String,
)