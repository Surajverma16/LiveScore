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
import com.example.scorecheckingapp.activity.MainActivity

class NewsHomePageAdapter (val homePageArray : List<HomepageArticle>, val context: Context) :  RecyclerView.Adapter<NewsHomePageAdapter.HomePageViewHolder>() {
    class HomePageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val sportsTypeName = itemView.findViewById<TextView>(R.id.sports_name_news)
//        val sportsRecyclerView = ite/**/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_news, parent,false)
        return HomePageViewHolder(itemView )
    }

    override fun getItemCount(): Int {
        Log.d("Sixe", homePageArray.size.toString())
        return  homePageArray.size
    }

    override fun onBindViewHolder(holder: HomePageViewHolder, position: Int) {
        holder.sportsTypeName.text = homePageArray[position].category.initialTitle
//        (context as MainActivity).findViewById<RecyclerView>(R.id.sports_name_news_recyclerView).adapter =
        holder.itemView.findViewById<RecyclerView>(R.id.sports_name_news_recyclerView).adapter = NewsHomeSportsAdapter(homePageArray[position].articles, context)

    }
}