package com.sumon.retrofitpagingmvvm.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitpagingmvvm.databinding.SumanBinding
import com.sumon.retrofitpagingmvvm.Model.Result

class QutesAdaprter:PagingDataAdapter<com.sumon.retrofitpagingmvvm.Model.Result,QutesAdaprter.quotesViewHolder> (Comparator){


    class quotesViewHolder( sumanBinding: SumanBinding)
        :RecyclerView.ViewHolder(sumanBinding.root)

    override fun onBindViewHolder(holder: quotesViewHolder, position: Int) {
        getItem(position).let {
            holder.
//            quoteTv.text = it?.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): quotesViewHolder {
        return quotesViewHolder(
            SumanBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

companion object {
    private val Comparator =
        object : DiffUtil.ItemCallback<com.sumon.retrofitpagingmvvm.Model.Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                TODO("Not yet implemented")
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                TODO("Not yet implemented")
            }


        }
}
}