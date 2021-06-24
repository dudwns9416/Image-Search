package com.sc.imagesearch.domain.model

data class Image(
    val collection: String = "",
    val dateTime: String = "",
    val displaySiteName: String = "",
    val docUrl: String = "",
    val height: Int = 0,
    val imageUrl: String,
    val thumbnailUrl: String = "",
    val width: Int = 0,
)
