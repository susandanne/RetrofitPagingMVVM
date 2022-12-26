package com.example.retrofitpagingmvvm.API

import com.example.retrofitpagingmvvm.Model.ResponseQuotes
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {
@GET("/quotes")
 suspend fun getAllQoutes(@Query("page") page: Int):ResponseQuotes
}