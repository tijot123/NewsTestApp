package com.app.newstestapp.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.newstestapp.R
import com.app.newstestapp.databinding.AdapterNewsBinding
import com.app.newstestapp.model.NewsArticles

class NewsAdapter(private val newsList: MutableList<NewsArticles>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: AdapterNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NewsArticles) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: AdapterNewsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.adapter_news,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = newsList.count()

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(newsList[position])
    }
}