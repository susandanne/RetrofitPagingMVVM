package com.example.retrofitpagingmvvm.Model

data class ResponseQuotes( val count: Int,
                           val lastItemIndex: Int,
                           val page: Int,
                           val results: List<Result>,
                           val totalCount: Int,
                           val totalPages: Int){

}
