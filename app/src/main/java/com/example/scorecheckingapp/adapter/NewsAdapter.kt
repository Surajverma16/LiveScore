package com.example.scorecheckingapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.scorecheckingapp.API.NewsApi.TopStory
import com.example.scorecheckingapp.R

class NewsAdapter(val newsArray: List<TopStory>, val context: Context, val clicked : onClickingNews) :
    RecyclerView.Adapter<NewsAdapter.itemViewHolder>() {
    class itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.news_image)
        val header = itemView.findViewById<TextView>(R.id.news_header_text)
        val sportsType = itemView.findViewById<TextView>(R.id.news_type_text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_news, parent, false)
        return itemViewHolder(itemView)
    }

    override fun getItemCount(): Int = newsArray.size

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.header.text = newsArray[position].title
        holder.sportsType.text = newsArray[position].categoryLabel
        Glide.with(context)
            .load(newsArray[position].mainMedia.gallery.url)
            .into(holder.image)
        holder.itemView.setOnClickListener {
            clicked.clickedNews(newsArray[position])
        }



    }
    interface onClickingNews{
        fun clickedNews(topStory: TopStory)
    }
}