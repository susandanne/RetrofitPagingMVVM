package com.example.retrofitpagingmvvm.DI

import com.example.retrofitpagingmvvm.API.QuotesApi
import com.example.retrofitpagingmvvm.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun getRetrofitbuilder():Retrofit.Builder{

     return Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create())

    }
@Singleton
@Provides
    fun  getQuoteApi(retrofit: Retrofit.Builder):QuotesApi{
        return retrofit.build().create(QuotesApi::class.java)
    }
}