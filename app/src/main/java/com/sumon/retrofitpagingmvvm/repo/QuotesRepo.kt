package com.sumon.retrofitpagingmvvm.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.sumon.retrofitpagingmvvm.api.QuotesApi
import com.sumon.retrofitpagingmvvm.pagination.QuotesPagingSource
import javax.inject.Inject

class QuotesRepo @Inject constructor (private val qoutesapi:QuotesApi) {
fun getallquotes()=Pager(
     config = PagingConfig(pageSize = 20, maxSize = 100),
    pagingSourceFactory = {QuotesPagingSource(qoutesapi)}

).liveData



}