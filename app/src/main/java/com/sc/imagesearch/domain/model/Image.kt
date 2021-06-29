package com.sc.imagesearch.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    val collection: String = "",
    val datetime: String = "",
    @SerializedName("display_sitename") val displaySiteName: String = "",
    @SerializedName("doc_url") val docUrl: String = "",
    val height: Int = 0,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("thumbnail_url") val thumbnailUrl: String = "",
    val width: Int = 0,
) : Parcelable
