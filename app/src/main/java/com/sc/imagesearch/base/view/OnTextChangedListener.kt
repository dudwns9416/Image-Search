package com.sc.imagesearch.base.view

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

class OnTextChangedListener(
    private val view: TextView,
    private val actionOnTextChanged: (TextViewTextChangeEvent) -> Unit
) : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        actionOnTextChanged.invoke(TextViewTextChangeEvent(view, s, start, before, count))
    }

    override fun afterTextChanged(s: Editable?) = Unit
}

fun TextView.onTextChanged(action: (TextViewTextChangeEvent) -> Unit) {
    val listener = OnTextChangedListener(this, action)
    this.addTextChangedListener(listener)
}

data class TextViewTextChangeEvent(
    val view: TextView,
    val text: CharSequence?,
    val start: Int,
    val before: Int,
    val count: Int
)