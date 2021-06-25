package com.sc.imagesearch

import android.app.Application
import com.sc.imagesearch.modules.networkModule
import com.sc.imagesearch.modules.repositoryModule
import com.sc.imagesearch.modules.useCaseModule
import com.sc.imagesearch.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ImageSearchApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ImageSearchApplication)
            modules(
                networkModule,
                repositoryModule,
                useCaseModule,
                viewModelModule,
            )
        }
    }
}