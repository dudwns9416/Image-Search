package com.sc.imagesearch.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.load(url: String, options: RequestOptions = RequestOptions()) {
    Glide.with(context).load(url).apply(options).into(this)
}