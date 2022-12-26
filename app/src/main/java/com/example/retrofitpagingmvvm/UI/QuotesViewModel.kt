package com.example.retrofitpagingmvvm.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.retrofitpagingmvvm.REPO.QuotesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel@Inject constructor(private val repo: QuotesRepo):ViewModel() {
    val quotelist=repo.getallquotes().cachedIn(viewModelScope)
}