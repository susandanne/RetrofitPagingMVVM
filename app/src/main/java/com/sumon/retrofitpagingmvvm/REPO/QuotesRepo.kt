package com.sumon.retrofitpagingmvvm.REPO

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.sumon.retrofitpagingmvvm.API.QuotesApi
import com.sumon.retrofitpagingmvvm.Pagination.QuotesPagingSource
import javax.inject.Inject

class QuotesRepo @Inject constructor (private val qoutesapi:QuotesApi) {
fun getallquotes()=Pager(
     config = PagingConfig(pageSize = 20, maxSize = 100),
    pagingSourceFactory = {QuotesPagingSource(qoutesapi)}

).liveData



}