package com.sumon.retrofitpagingmvvm.Pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sumon.retrofitpagingmvvm.API.QuotesApi
import com.sumon.retrofitpagingmvvm.Model.Result


class QuotesPagingSource(private val api: QuotesApi) :PagingSource<Int,Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val position = params.key ?: 1

            val response = api.getAllQoutes(position)

            LoadResult.Page(
                response.results,
                if (position == 1) null else position - 1,
                if (position == response.totalPages) null else position + 1
            )
        } catch (e: java.lang.Exception) {
            LoadResult.Error(e)
        }
    }
}