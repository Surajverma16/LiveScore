package com.example.scorecheckingapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.scorecheckingapp.API.CricketApi.Event
import com.example.scorecheckingapp.API.CricketApi.Stage
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.activity.MainActivity
import com.example.scorecheckingapp.fragments.Cricket.CricketMatchDetailsFragment

class CricketLeagueAdapter( val cricketArray : ArrayList<Stage>, val context: Context) : RecyclerView.Adapter<CricketLeagueAdapter.cricketViewHolder>() {
    class cricketViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val leagueLogo = itemView.findViewById<ImageView>(R.id.img_league_logo)
        val leagueText = itemView.findViewById<TextView>(R.id.txt_league_name)
        val leagueCountry = itemView.findViewById<TextView>(R.id.txt_league_country)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cricketViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_of_cricket_leagues, parent,false)
        return cricketViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cricketArray.size
    }

    override fun onBindViewHolder(holder: cricketViewHolder, position: Int) {
        holder.leagueText.text = cricketArray[position].Snm
        holder.leagueCountry.text = cricketArray[position].Cnm
        Glide.with(context)
            .load("https://static.livescore.com/i2/fh/xcr-${cricketArray[position].Ccd}.jpg")
            .into(holder.leagueLogo)

        holder.itemView.findViewById<RecyclerView>(R.id.recyclerView_Events).adapter = CricketScoreAdapter(cricketArray[position].Events, object : CricketScoreAdapter.onCLickedMatch {
            override fun onClicked(event: Event) {
                (context as MainActivity).supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment_container, CricketMatchDetailsFragment(event))
                    addToBackStack("LiveScore")
                    commit()
                }
            }
        })
    }
}