package com.sumon.retrofitpagingmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import com.example.retrofitpagingmvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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
adapter.submitData(lifecycle,it)

}



    }
    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            var errMessage = loadState.error.localizedMessage
            Log.i("TAG", "$errMessage ")

        }

    }
}