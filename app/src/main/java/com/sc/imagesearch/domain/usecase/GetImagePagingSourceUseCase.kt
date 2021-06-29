package com.sc.imagesearch.domain.usecase

import androidx.paging.PagingData
import com.sc.imagesearch.domain.model.Image
import kotlinx.coroutines.flow.Flow

interface GetImagePagingSourceUseCase {

    fun invoke(query: String): Flow<PagingData<Image>>
}