package com.example.retrofitpagingmvvm.REPO

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.liveData
import com.example.retrofitpagingmvvm.API.QuotesApi
import com.example.retrofitpagingmvvm.Pagination.QuotesPagingSource
import javax.inject.Inject
import kotlin.math.max

class QuotesRepo @Inject constructor (private val qoutesapi:QuotesApi) {
fun getallquotes()=Pager(
     config = PagingConfig(pageSize = 20, maxSize = 100),
    pagingSourceFactory = {QuotesPagingSource(qoutesapi)}

).liveData



}