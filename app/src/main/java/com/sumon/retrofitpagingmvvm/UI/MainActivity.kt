package com.sumon.retrofitpagingmvvm.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import com.example.retrofitpagingmvvm.R
import com.example.retrofitpagingmvvm.databinding.ActivityMainBinding
import com.sumon.retrofitpagingmvvm.UI.QuotesViewModel
import com.sumon.retrofitpagingmvvm.UI.QutesAdaprter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.security.Provider

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: QuotesViewModel
    lateinit var adapter:QutesAdaprter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            adapter= QutesAdaprter()
        binding.quotesRecyclerview.adapter=adapter



        lifecycleScope.launch{
            (adapter as PagingDataAdapter<*,*>).loadStateFlow.collectLatest { loadstae->
           when(loadstae.refresh){
               is LoadState.Loading->{
                   Log.i("TAG", "Loading.... ")
               }
               is LoadState.Error->{
                   bind(loadstae.refresh)

               }
               is LoadState.NotLoading->{
                   Log.i("TAG", "Not Loading.... ")
               }
           }

            }
        }


    viewModel=ViewModelProvider(this)[QuotesViewModel::class.java]

viewModel.quotelist.observe(this){
adapter.submitData(lifecycle, it
)
}



    }
    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            var errMessage = loadState.error.localizedMessage
            Log.i("TAG", "$errMessage ")

        }

    }
}