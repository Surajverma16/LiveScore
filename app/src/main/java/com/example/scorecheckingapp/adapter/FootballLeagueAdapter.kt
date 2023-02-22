package com.example.scorecheckingapp.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.scorecheckingapp.R

class FootballLeagueAdapter(val leagueList : ArrayList<com.example.scorecheckingapp.API.Stage>?, val context: Context) : RecyclerView.Adapter<FootballLeagueAdapter.myViewHolder>() {
    class myViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val leagueImage = itemView.findViewById<ImageView>(R.id.img_league_logo)
        val leagueName = itemView.findViewById<TextView>(R.id.txt_league_name)
        val leagueCountry = itemView.findViewById<TextView>(R.id.txt_league_country)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_football_leagues,parent,false)
        return myViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       if(leagueList == null){
           return 0
       }
        return leagueList.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.leagueName.text = leagueList!![position].Snm
        holder.leagueCountry.text = leagueList[position].Cnm
        //https://static.livescore.com/i2/fh/england.jpg
        Glide.with(context)
            .load("https://static.livescore.com/i2/fh/${leagueList[position].Ccd}.jpg")
            .into(holder.leagueImage)

//        holder.leagueImage.setImageResource(Glide.with(context).load("https://static.livescore.com/i2/fh/${leagueList[position]}.jpg").into())
        holder.itemView.findViewById<RecyclerView>(R.id.recyclerView_Events).adapter = FootballAdapterScore(leagueList[position].Events, context)
    }
}