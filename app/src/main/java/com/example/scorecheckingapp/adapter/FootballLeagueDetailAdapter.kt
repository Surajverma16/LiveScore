package com.example.scorecheckingapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.scorecheckingapp.API.matchApi.Event
import com.example.scorecheckingapp.API.matchApi.Stage
import com.example.scorecheckingapp.R

class FootballLeagueDetailAdapter(val leagueArray : ArrayList<Stage>, val context : Context):RecyclerView.Adapter<FootballLeagueDetailAdapter.leagueDetailsViewHolder>() {
    class leagueDetailsViewHolder(view : View): RecyclerView.ViewHolder(view) {
        val leagueImage = view.findViewById<ImageView>(R.id.img_league_logo)
        val leagueName = view.findViewById<TextView>(R.id.txt_league_name)
        val leagueCountry = view.findViewById<TextView>(R.id.txt_league_country)
        val leagueArrow = view.findViewById<ImageView>(R.id.arrowOfLeague)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): leagueDetailsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_football_leagues, parent,false)
        return leagueDetailsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
    return leagueArray.size
    }

    override fun onBindViewHolder(holder: leagueDetailsViewHolder, position: Int) {
        holder.leagueName.text = leagueArray[position].Cnm
        holder.leagueCountry.text = leagueArray[position].Snm
        Glide.with(context)
            .load("https://static.livescore.com/i2/fh/${leagueArray[position].Ccd}.jpg")
            .into(holder.leagueImage)
        holder.leagueArrow.setImageURI(null)

        holder.itemView.findViewById<RecyclerView>(R.id.recyclerView_Events).adapter = FootballAdapterScore(leagueArray[position].Events, context, object : FootballAdapterScore.onClickedItem {
            override fun setOnClickingEvent(event: Event) {
                Toast.makeText(context, "Nothing", Toast.LENGTH_SHORT).show()
            }
        })
    }
}