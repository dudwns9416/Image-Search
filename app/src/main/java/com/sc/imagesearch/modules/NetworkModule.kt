package com.sc.imagesearch.modules

import com.sc.imagesearch.BuildConfig
import com.sc.imagesearch.data.network.ImageSearchService
import com.sc.imagesearch.network.TokenInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { (get() as Retrofit).create(ImageSearchService::class.java) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.KAKAO_API)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()

fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient.Builder().addInterceptor(TokenInterceptor()).build()
