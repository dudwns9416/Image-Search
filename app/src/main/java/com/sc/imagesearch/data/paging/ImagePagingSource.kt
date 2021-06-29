package com.sc.imagesearch.data.paging

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.sc.imagesearch.domain.model.Image
import com.sc.imagesearch.domain.repository.ImageRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class ImagePagingSource(
    private val imageRepository: ImageRepository,
    private val query: String
) : RxPagingSource<Int, Image>() {

    override fun getRefreshKey(state: PagingState<Int, Image>): Int? {
        return state.anchorPosition
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Image>> {
        val position = params.key ?: 1
        return imageRepository.findImagesWithPage(query, position, 30)
            .subscribeOn(Schedulers.io())
            .map<LoadResult<Int, Image>> { result ->
                LoadResult.Page(
                    data = result.documents,
                    prevKey = if (position == 1) null else position - 1,
                    nextKey = if (result.meta.isEnd) null else position + 1
                )
            }
            .onErrorReturn {
                LoadResult.Error(it)
            }
    }
}