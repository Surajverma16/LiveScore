package com.example.scorecheckingapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.dataClass.ViewFavouriteClass

class FavouriteAdapter(val context: Context, val favourList: List<ViewFavouriteClass>) : RecyclerView.Adapter<FavouriteAdapter.myFavourite>() {
    class myFavourite(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val footballTime = itemView.findViewById<TextView>(R.id.football_match_timing)
        val footballFirstImage = itemView.findViewById<ImageView>(R.id.first_team_image)
        val footballSecondImage = itemView.findViewById<ImageView>(R.id.second_team_image)
        val footballFirstName = itemView.findViewById<TextView>(R.id.first_team_name_txt)
        val footballSecondName = itemView.findViewById<TextView>(R.id.second_team_name_txt)
        val footballFirstScore = itemView.findViewById<TextView>(R.id.display_current_score_first_team)
        val footballSecondScore = itemView.findViewById<TextView>(R.id.display_current_score_second_team)
        val star = itemView.findViewById<ImageView>(R.id.favourite_star)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myFavourite {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_football_games, parent, false)
        return myFavourite(itemView)
    }

    override fun getItemCount(): Int {
        return favourList.size
    }

    override fun onBindViewHolder(holder: myFavourite, position: Int) {
        holder.footballTime.text = favourList[position].Time
        holder.footballFirstName.text = favourList[position]!!.T1Name
        holder.footballSecondName.text = favourList[position]!!.T2Name
        Glide.with(context)
            .load("https://lsm-static-prod.livescore.com/medium/${favourList[position].T1Image}" )
            .into(holder.footballFirstImage)
        Glide.with(context)
            .load("https://lsm-static-prod.livescore.com/medium/${favourList[position].T2Image}")
            .into(holder.footballSecondImage)
    }
}