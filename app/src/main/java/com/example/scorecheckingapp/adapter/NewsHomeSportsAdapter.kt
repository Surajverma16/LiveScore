package com.example.scorecheckingapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.scorecheckingapp.API.NewsApi.Article
import com.example.scorecheckingapp.R

class NewsHomeSportsAdapter(val HomeArray : List<Article>, val context: Context) : RecyclerView.Adapter<NewsHomeSportsAdapter.myviewHolderHome>() {
    class myviewHolderHome(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.news_image)
        val header = itemView.findViewById<TextView>(R.id.news_header_text)
        val sportsType = itemView.findViewById<TextView>(R.id.news_type_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewHolderHome {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_news, parent, false)
        return myviewHolderHome(itemView)
    }
    override fun getItemCount(): Int = HomeArray.size


    override fun onBindViewHolder(holder: myviewHolderHome, position: Int) {
        holder.header.text = HomeArray[position].title
        holder.sportsType.text = HomeArray[position].categoryLabel
        Glide.with(context)
            .load(HomeArray[position].mainMedia.gallery.url)
            .into(holder.image)
    }





}
