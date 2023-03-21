package com.example.scorecheckingapp.adapter

import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.scorecheckingapp.API.favouriteApi.favourite
import com.example.scorecheckingapp.API.matchApi.Event
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.dataClass.ListFavouriteId
import com.google.common.collect.Range.range
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlin.math.log

class FootballAdapterScore(
    var footballList: ArrayList<Event>?,
    val context: Context,
    val clicked: onClickedItem,
) :
    RecyclerView.Adapter<FootballAdapterScore.ViewHoldder>() {
    lateinit var auth: FirebaseAuth
    lateinit var database: DatabaseReference
    var list = arrayListOf<String>()
    lateinit var dataSample: ListFavouriteId

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

        val star = itemView.findViewById<ImageView>(R.id.favourite_star)
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
        return footballList!!.size
    }

    override fun onBindViewHolder(holder: ViewHoldder, position: Int) {
        holder.footballTime.text = footballList!![position].Eps
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

        dataSample = ListFavouriteId(
            footballList!![position].Eid,
            holder.footballFirstName.text.toString(),
            holder.footballSecondName.text.toString(),
            footballList!![position].T1[0].Img,
            footballList!![position].T2[0].Img,
            holder.footballTime.text.toString()
        )

        if (footballList!![position].Eps == "NS") {
            holder.star.setOnClickListener {
                it.setBackgroundColor(Color.parseColor("#FF5722"))

                userData(footballList!![position].toString())
            }
        } else if (footballList!![position].Eps == "Postp.") {
            holder.star.setOnClickListener {
                Toast.makeText(
                    context,
                    "Couldn't Add to Favourite As Match Has Been postponed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            holder.star.setOnClickListener {
                Toast.makeText(context, "Match has Been Finished", Toast.LENGTH_SHORT).show()
            }
        }

        holder.itemView.setOnClickListener {
            clicked.setOnClickingEvent(footballList!![position])
        }
    }

    private fun userData(eid: String) {
        val user = FirebaseAuth.getInstance().currentUser!!.uid
        val data = FirebaseDatabase.getInstance()

        data.getReference("users/$user").child("listId").push().setValue(dataSample)
        database = Firebase.database.reference
        database.child("users/$user/listId").get().addOnSuccessListener {
            for (i in it.children) {

                Log.d("ListForChildren", it.children.elementAt(0).value.toString())

            }
        }
    }

    interface onClickedItem {
        fun setOnClickingEvent(event: Event)
    }
}