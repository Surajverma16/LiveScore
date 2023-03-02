package com.example.scorecheckingapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.scorecheckingapp.API.NewsApi.Article
import com.example.scorecheckingapp.R

class NewsHomePageArticlAdapter (val homeArray : List<Article>, val context : Context) : RecyclerView.Adapter<NewsHomePageArticlAdapter.myHomearticle>() {
    class myHomearticle(itemView :View) :RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.news_image)
        val header = itemView.findViewById<TextView>(R.id.news_header_text)
        val sportsType = itemView.findViewById<TextView>(R.id.news_type_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHomearticle {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_news,parent,false)
        return myHomearticle(itemView)
        }

    override fun getItemCount(): Int {
        return  homeArray.size
    }

    override fun onBindViewHolder(holder: myHomearticle, position: Int) {
        Log.d("Response",homeArray[position].toString())
        holder.header.text = homeArray[position].title
        holder.sportsType.text = homeArray[position].categoryLabel
        Glide.with(context)
            .load(homeArray[position].mainMedia.gallery.url)
            .into(holder.image)
    }

}
