package com.sumon.retrofitpagingmvvm.model

data class ResponseQuotes( val count: Int,
                           val lastItemIndex: Int,
                           val page: Int,
                           val results: List<Result>,
                           val totalCount: Int,
                           val totalPages: Int){

}
