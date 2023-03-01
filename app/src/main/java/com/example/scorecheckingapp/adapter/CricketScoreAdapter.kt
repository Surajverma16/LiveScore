package com.example.scorecheckingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scorecheckingapp.API.CricketApi.TypeMatche
import com.example.scorecheckingapp.API.matchApi.Stage
import com.example.scorecheckingapp.R

class CricketScoreAdapter(val cricketArray : List<TypeMatche>) : RecyclerView.Adapter<CricketScoreAdapter.cricketScore>() {
    class cricketScore(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cricketScore {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_of_cricket_leagues, parent, false)
        return cricketScore(itemView)
    }

    override fun getItemCount(): Int {
        return cricketArray.size
    }

    override fun onBindViewHolder(holder: cricketScore, position: Int) {

    }
}