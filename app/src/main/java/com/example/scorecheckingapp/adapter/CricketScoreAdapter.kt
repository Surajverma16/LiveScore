package com.example.scorecheckingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.scorecheckingapp.API.CricketApi.Event
import com.example.scorecheckingapp.R

class CricketScoreAdapter(val cricketArray : ArrayList<Event>, val clicked : onCLickedMatch) : RecyclerView.Adapter<CricketScoreAdapter.cricketScore>() {
    class cricketScore(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val matchType = itemView.findViewById<TextView>(R.id.match_type_text)
        val teamOneName = itemView.findViewById<TextView>(R.id.team_1_name_text)
        val teamTwoName = itemView.findViewById<TextView>(R.id.team_2_name_text)
        val matchSituation = itemView.findViewById<TextView>(R.id.match_situation_text)
        val teamOneScore = itemView.findViewById<TextView>(R.id.team_1_score_text)
        val teamTwoScore = itemView.findViewById<TextView>(R.id.team_2_score_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cricketScore {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_of_cricket_games, parent, false)
        return cricketScore(itemView)
    }

    override fun getItemCount(): Int {
        return cricketArray.size
    }

    override fun onBindViewHolder(holder: cricketScore, position: Int) {
        holder.matchType.text = cricketArray[position].EtTx
        holder.teamOneName.text = cricketArray[position].T1[0].Nm
        holder.teamTwoName.text = cricketArray[position].T2[0].Nm
        holder.matchSituation.text= cricketArray[position].ECo
        holder.teamOneScore.text = cricketArray[position].Tr1C1.toString()
        holder.teamTwoScore.text = cricketArray[position].Tr2C1.toString()

        holder.itemView.setOnClickListener {
            clicked.onClicked(cricketArray[position])
        }

    }
    interface  onCLickedMatch{
        fun onClicked(event: Event)
    }
}