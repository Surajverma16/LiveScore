package com.example.scorecheckingapp.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.scorecheckingapp.ABC
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.dataClass.FootballScoreDataClass

class FootballScoreAdapter(
    var footballList: ArrayList<FootballScoreDataClass>,
    val context: Context,
    val clickedlistener: onSingleItemClick,

    ) :
    RecyclerView.Adapter<FootballScoreAdapter.viewHolder>() {
    var onItemClick: ((FootballScoreDataClass) -> Unit)? = null

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_football_games, parent, false)
        return viewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return footballList.size
    }

    @SuppressLint("CommitTransaction")
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.footballTime.text = footballList[position].time
        holder.footballFirstImage.setImageResource(footballList[position].firstTeamImage)
        holder.footballSecondImage.setImageResource(footballList[position].secondTeamImage)
        holder.footballFirstName.text = footballList[position].firstTeamName
        holder.footballSecondName.text = footballList[position].secondTeamName
        holder.footballFirstScore.text = footballList[position].firstTeamScore.toString()
        holder.footballSecondScore.text = footballList[position].secondTeamScore.toString()

        holder.itemView.setOnClickListener {
            clickedlistener.clicked(footballList[position])
        }
    }

    interface onSingleItemClick {
        fun clicked(footballScoreDataClass: FootballScoreDataClass)
    }


}