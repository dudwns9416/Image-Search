package com.sc.imagesearch.extensions

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME

fun String?.formatted(): String {
    return try {
        val parse = LocalDateTime.parse(this, ISO_OFFSET_DATE_TIME)
        parse.format(DateTimeFormatter.ofPattern("yyyy-MM-dd (E) HH:mm:ss"))
    } catch (ex: Exception) {
        this.orEmpty()
    }
}
