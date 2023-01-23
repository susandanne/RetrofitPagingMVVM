package com.sumon.retrofitpagingmvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitpagingmvvm.databinding.SumanBinding
import com.sumon.retrofitpagingmvvm.moviewmodel.MovieResult

class QutesAdaprter:PagingDataAdapter<MovieResult,QutesAdaprter.quotesViewHolder> (Comparator){


    class quotesViewHolder(public val sumanBinding: SumanBinding)
        :RecyclerView.ViewHolder(sumanBinding.root)

    override fun onBindViewHolder(holder: quotesViewHolder, position: Int) {
        getItem(position).let {
            Glide.with(holder.sumanBinding.root.context).load(Util.posterUrlMake(it?.posterPath))
                .into(holder.sumanBinding.image)

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
        object : DiffUtil.ItemCallback<MovieResult>() {
            override fun areItemsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean {
           return oldItem.id==newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean {
                return oldItem==newItem
            }


        }
}
}