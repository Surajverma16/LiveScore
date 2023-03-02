package com.example.scorecheckingapp.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.text.style.BackgroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.setViewTreeOnBackPressedDispatcherOwner
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.scorecheckingapp.API.NewsApi.Categories
import com.example.scorecheckingapp.API.NewsApi.Category
import com.example.scorecheckingapp.API.NewsApi.News
import com.example.scorecheckingapp.R

class NewsCategoriesAdapter(
    val categoriesArray: List<Category>,
    val context: Context,
    val clicked: onClickedCategories,
) :
    RecyclerView.Adapter<NewsCategoriesAdapter.categoriesViewHolder>() {
    var selectedItem: Int = -1


    class categoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categories = itemView.findViewById<TextView>(R.id.cateegories_text)
        val card = itemView.findViewById<CardView>(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categoriesViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_categories_news, parent, false)
        return categoriesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return categoriesArray.size
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("SuspiciousIndentation", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: categoriesViewHolder, position: Int) {
        holder.categories.text = categoriesArray[position].title
        holder.categories.setOnClickListener {
            clicked.clickedCategories(categoriesArray[position])
            selectedItem = position
            notifyDataSetChanged()
        }
        if(selectedItem == position){
            holder.categories.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            holder.categories.setTextColor(Color.parseColor("#FF000000"))
        }
        else{
            holder.categories.setBackgroundColor(Color.parseColor("#424242"))
            holder.categories.setTextColor(Color.parseColor("#FFFFFFFF"))
        }

    }

    interface onClickedCategories {
        fun clickedCategories(category: Category)

    }

}