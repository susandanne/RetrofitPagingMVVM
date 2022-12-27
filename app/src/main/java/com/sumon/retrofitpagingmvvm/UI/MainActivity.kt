package com.sumon.retrofitpagingmvvm.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitpagingmvvm.R
import com.example.retrofitpagingmvvm.databinding.ActivityMainBinding
import com.sumon.retrofitpagingmvvm.UI.QuotesViewModel
import com.sumon.retrofitpagingmvvm.UI.QutesAdaprter
import dagger.hilt.android.AndroidEntryPoint
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
    viewModel=ViewModelProvider(this)[QuotesViewModel::class.java]

viewModel.quotelist.observe(this){
adapter.submitData(lifecycle,it)
}
    }
}