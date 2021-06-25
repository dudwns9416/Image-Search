package com.sc.imagesearch.modules

import com.sc.imagesearch.data.repository.ImageRepositoryImpl
import com.sc.imagesearch.domain.repository.ImageRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ImageRepository> { ImageRepositoryImpl(get()) }
}