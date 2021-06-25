package com.sc.imagesearch.base.view

import android.view.View

class OnThrottleClickListener(
    private val onClickLister: View.OnClickListener,
    private val interval: Long = 300
) : View.OnClickListener {

    private var clickable = true

    override fun onClick(v: View?) {
        if (clickable) {
            clickable = false
            v?.run {
                postDelayed({ clickable = true }, interval)
                onClickLister.onClick(v)
            }
        }
    }

}

fun View.onThrottleClick(action: (View) -> Unit) {
    val listener = View.OnClickListener { action(it) }
    setOnClickListener(OnThrottleClickListener(listener))
}

fun View.onThrottleClick(action: (view: View) -> Unit, interval: Long) {
    val listener = View.OnClickListener { action(it) }
    setOnClickListener(OnThrottleClickListener(listener, interval))
}