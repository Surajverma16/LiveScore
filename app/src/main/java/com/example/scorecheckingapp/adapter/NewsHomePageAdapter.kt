package com.example.scorecheckingapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.scorecheckingapp.API.NewsApi.Article
import com.example.scorecheckingapp.API.NewsApi.HomepageArticle
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.activity.MainActivity
import com.example.scorecheckingapp.fragments.News.NewsHomePageDetails

class NewsHomePageAdapter(val homeArray: List<HomepageArticle>, val context: Context/*, val clicked : onClickedArrow*/) :
    RecyclerView.Adapter<NewsHomePageAdapter.newsViewHolder>() {
    class newsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val homeTitle = itemView.findViewById<TextView>(R.id.news_homepage_title)
        val homeArrow = itemView.findViewById<ImageView>(R.id.arrowOFNewsHomePage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_homepage_news, parent, false)
        return newsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        Log.d("Size", homeArray.size.toString())
        return homeArray.size
    }

    override fun onBindViewHolder(holder: newsViewHolder, position: Int) {
        holder.homeTitle.text = homeArray[position].category.initialTitle
/*        holder.homeArrow.setOnClickListener {
            clicked.onClicked(homeArray[position])
        }*/
        holder.itemView.findViewById<RecyclerView>(R.id.homepage_news_recyclerView).adapter =
            NewsHomePageArticlAdapter(homeArray[position].articles, context, object : NewsHomePageArticlAdapter.onClickedHomePageArticle {
                override fun onClicked(homepageArticle: Article) {
                    (context as MainActivity).supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragment_container, NewsHomePageDetails(homepageArticle))
                        addToBackStack("News")
                        commit()
                    }
                }
            })
        Log.d("adapter", homeArray[position].toString())


    }

    interface onClickedArrow {
        fun onClicked(homepageArticle: HomepageArticle)
    }


}