package com.sumon.retrofitpagingmvvm.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sumon.retrofitpagingmvvm.api.QuotesApi
import com.sumon.retrofitpagingmvvm.moviewmodel.MovieResult


class QuotesPagingSource(private val api: QuotesApi) :PagingSource<Int,MovieResult>() {
    override fun getRefreshKey(state: PagingState<Int,MovieResult>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int,MovieResult> {
        return try {
            val position = params.key ?: 1

            val response = api.getalldata("en-US",position)

            LoadResult.Page(
                response.movieResults,
                if (position == 1) null else position - 1,
                if (position == response.totalPages) null else position + 1
            )
        } catch (e: java.lang.Exception) {
            LoadResult.Error(e)
        }
    }
}