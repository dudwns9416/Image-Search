package com.sc.imagesearch.extensions

import android.view.View

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}