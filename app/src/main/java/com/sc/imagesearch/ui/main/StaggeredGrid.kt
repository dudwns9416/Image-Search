package com.sc.imagesearch.ui.main

import android.content.res.Resources

object StaggeredGrid {

    fun getWidthRatio(spanCount:Int, width: Int) = (getWidthOfScreen() / spanCount.toFloat()) / width

    private fun getWidthOfScreen() = Resources.getSystem().displayMetrics.widthPixels
}