package com.sc.imagesearch.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

fun ImageView.load(url: String, options: RequestOptions = RequestOptions()) {
    Glide.with(context)
        .load(url)
        .transition(withCrossFade(CrossFadeFactory.get()))
        .apply(options)
        .into(this)
}

object CrossFadeFactory {

    fun get(): DrawableCrossFadeFactory {
        if (::factory.isInitialized) {
            return factory
        }
        factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
        return factory
    }

    private lateinit var factory: DrawableCrossFadeFactory
}