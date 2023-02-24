package com.example.scorecheckingapp.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.scorecheckingapp.API.NewsApi.Category
import com.example.scorecheckingapp.R

class NewsCategoriesAdapter(val categoriesArray: List<Category>, val context: Context) :
    RecyclerView.Adapter<NewsCategoriesAdapter.categoriesViewHolder>() {


    class categoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categories = itemView.findViewById<TextView>(R.id.cateegories_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categoriesViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_categories_news, parent, false)
        return categoriesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return categoriesArray.size
    }

    override fun onBindViewHolder(holder: categoriesViewHolder, position: Int) {
    holder.categories.text = categoriesArray[position].title
        /*holder.categories.setOnClickListener {
            onCLickedItem.onClicked(categoriesArray[position].id)
            Toast.makeText(context, categoriesID, Toast.LENGTH_SHORT).show()
        }*/
    }

}