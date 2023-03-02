package com.example.scorecheckingapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.scorecheckingapp.API.NewsApi.HomepageArticle
import com.example.scorecheckingapp.R

class NewsHomePageAdapter(val homeArray : List<HomepageArticle>, val context : Context) : RecyclerView.Adapter<NewsHomePageAdapter.newsViewHolder>() {
    class newsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val homeTitle = itemView.findViewById<TextView>(R.id.news_homepage_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_homepage_news, parent,false)
        return  newsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        Log.d("Size", homeArray.size.toString())
        return homeArray.size
    }

    override fun onBindViewHolder(holder: newsViewHolder, position: Int) {
        holder.homeTitle.text = homeArray[position].category.initialTitle
        holder.itemView.findViewById<RecyclerView>(R.id.homepage_news_recyclerView).adapter = NewsHomePageArticlAdapter(homeArray[position].articles, context)
        Log.d("adapter", homeArray[position].toString())

    }
}