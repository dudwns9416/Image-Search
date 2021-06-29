package com.sc.imagesearch.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sc.imagesearch.data.paging.ImagePagingSource
import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow

class GetImagePagingSourceUseCaseImpl(
    private val imageRepository: ImageRepository
) : GetImagePagingSourceUseCase {

    override fun invoke(query: String): Flow<PagingData<Image>> {
        return Pager(
            PagingConfig(pageSize = 30)
        ) {
            ImagePagingSource(imageRepository, query)
        }.flow
    }
}