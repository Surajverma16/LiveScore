package com.example.scorecheckingapp.adapter

import android.annotation.SuppressLint
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.scorecheckingapp.API.NewsApi.Body
import com.example.scorecheckingapp.API.NewsApi.BodyX
import com.example.scorecheckingapp.API.NewsApi.details
import com.example.scorecheckingapp.R
import org.jsoup.Jsoup


class NewsDescriptionAdapter(val detailsList : List<BodyX>) : RecyclerView.Adapter<NewsDescriptionAdapter.newsDescription>() {
class newsDescription (itemView :View) : RecyclerView.ViewHolder(itemView){

    val textDescription = itemView.findViewById<TextView>(R.id.description_news_text)
}

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsDescription {
    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_news_details_description,parent,false)
        return newsDescription(itemView)
    }

    override fun getItemCount(): Int {
        return detailsList.size
    }

    override fun onBindViewHolder(holder: newsDescription, position: Int) {

        holder.textDescription.text =  Jsoup.parse(detailsList[position].data.content).text()

    }
}

