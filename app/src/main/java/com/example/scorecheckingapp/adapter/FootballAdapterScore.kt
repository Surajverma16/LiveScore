package com.example.scorecheckingapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.scorecheckingapp.API.Event
import com.example.scorecheckingapp.API.Stage
import com.example.scorecheckingapp.R

class FootballAdapterScore(
    var footballList: ArrayList<Event>?, val context: Context) :
    RecyclerView.Adapter<FootballAdapterScore.ViewHoldder>() {

    class ViewHoldder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val footballTime = itemView.findViewById<TextView>(R.id.football_match_timing)
        val footballFirstImage = itemView.findViewById<ImageView>(R.id.first_team_image)
        val footballSecondImage = itemView.findViewById<ImageView>(R.id.second_team_image)
        val footballFirstName = itemView.findViewById<TextView>(R.id.first_team_name_txt)
        val footballSecondName = itemView.findViewById<TextView>(R.id.second_team_name_txt)
        val footballFirstScore =
            itemView.findViewById<TextView>(R.id.display_current_score_first_team)
        val footballSecondScore =
            itemView.findViewById<TextView>(R.id.display_current_score_second_team)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_football_games, parent, false)
        return ViewHoldder(itemView)
    }

    override fun getItemCount(): Int {
        if (footballList == null) {
            return 0
        }
        Log.d("Size", footballList!!.size.toString())
        return footballList!!.size
    }

    override fun onBindViewHolder(holder: ViewHoldder, position: Int) {
        holder.footballTime.text = footballList!![position].Eps
//        holder.footballFirstName.text = footballList!![position].Events[position].T1[position].Nm
//        holder.footballSecondName.text = footballList!![position].Events[position].T2[position].Nm
        Glide.with(context)
            .load("https://lsm-static-prod.livescore.com/medium/${footballList!![position].T1[0].Img}")
            .into(holder.footballFirstImage)

        Glide.with(context)
            .load("https://lsm-static-prod.livescore.com/medium/${footballList!![position].T2[0].Img}")
            .into(holder.footballSecondImage)
        holder.footballFirstName.text = footballList!![position].T1[0].Nm
        holder.footballSecondName.text = footballList!![position].T2[0].Nm

        holder.footballFirstScore.text = footballList!![position].Tr1
        holder.footballSecondScore.text = footballList!![position].Tr2
//        holder.footballFirstName.text = footballList[position].
    }

    interface onitemClicked {}


}