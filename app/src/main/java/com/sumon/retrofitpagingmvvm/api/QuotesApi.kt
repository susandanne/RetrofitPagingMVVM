package com.sumon.retrofitpagingmvvm.api

import com.sumon.retrofitpagingmvvm.Constant.key
import com.sumon.retrofitpagingmvvm.moviewmodel.ResponseUpcomingMovie
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {
//@GET("/quotes")
// suspend fun getAllQoutes(@Query("page") page: Int):ResponseQuotes

 @GET("3/movie/upcoming?api_key=$key")
 suspend fun getalldata(
     @Query("language") language: String,
     @Query("page") page:Int

 ):ResponseUpcomingMovie
}