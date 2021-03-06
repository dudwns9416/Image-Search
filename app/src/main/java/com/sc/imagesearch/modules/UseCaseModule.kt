package com.sc.imagesearch.modules

import com.sc.imagesearch.domain.usecase.GetImagePagingSourceUseCase
import com.sc.imagesearch.domain.usecase.GetImagePagingSourceUseCaseImpl
import com.sc.imagesearch.domain.usecase.GetImagesUseCase
import com.sc.imagesearch.domain.usecase.GetImagesUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetImagesUseCase> { GetImagesUseCaseImpl(get()) }
    single<GetImagePagingSourceUseCase> { GetImagePagingSourceUseCaseImpl(get()) }
}