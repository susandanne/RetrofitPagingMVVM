package com.sumon.retrofitpagingmvvm.API

import com.sumon.retrofitpagingmvvm.Model.ResponseQuotes
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {
@GET("/quotes")
 suspend fun getAllQoutes(@Query("page") page: Int):ResponseQuotes
}