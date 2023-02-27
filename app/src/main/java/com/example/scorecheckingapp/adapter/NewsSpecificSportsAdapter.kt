package com.example.scorecheckingapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.scorecheckingapp.API.NewsApi.Data
import com.example.scorecheckingapp.R

class NewsSpecificSportsAdapter (val context: Context,val specificArray : List<Data>): RecyclerView.Adapter<NewsSpecificSportsAdapter.newsHolder>() {
    class newsHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.news_image)
        val header = itemView.findViewById<TextView>(R.id.news_header_text)
        val sportsType = itemView.findViewById<TextView>(R.id.news_type_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_news, parent, false)
        return newsHolder(itemView)
    }

    override fun getItemCount(): Int {
       return  specificArray.size
    }

    override fun onBindViewHolder(holder: newsHolder, position: Int) {

        holder.header.text = specificArray[position].title
        holder.sportsType.text = specificArray[position].category.title
        Glide.with(context)
            .load(specificArray[position].image.data.urls.uploaded.gallery)
            .into(holder.image)
    }
}