package com.sumon.retrofitpagingmvvm.UI

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sumon.retrofitpagingmvvm.Model.Result

class QutesAdaprter:PagingDataAdapter<com.sumon.retrofitpagingmvvm.Model.Result,QutesAdaprter.quotesViewHolder> (Comparator){


    class quotesViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)

    override fun onBindViewHolder(holder: quotesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): quotesViewHolder {
        TODO("Not yet implemented")
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