package com.example.scorecheckingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.dataClass.NewsDataClass

class NewsAdapter(val newsArray: ArrayList<NewsDataClass>) :
    RecyclerView.Adapter<NewsAdapter.itemViewHolder>() {
    class itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.news_image)
        val header = itemView.findViewById<TextView>(R.id.news_header_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_news, parent, false)
        return itemViewHolder(itemView)
    }

    override fun getItemCount(): Int = newsArray.size

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.image.setImageResource(newsArray[position].newsImage)
        holder.header.text = newsArray[position].newsHeadLine
    }
}