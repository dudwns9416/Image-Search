package com.sc.imagesearch.network

import com.sc.imagesearch.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = BuildConfig.KAKAO_TOKEN

        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", token)
            .build()

        return chain.proceed(request)
    }
}