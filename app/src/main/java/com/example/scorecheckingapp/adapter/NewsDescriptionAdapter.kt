//package com.example.scorecheckingapp.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.lifecycle.findViewTreeViewModelStoreOwner
//import androidx.recyclerview.widget.RecyclerView
//import com.example.scorecheckingapp.R
//
//class NewsDescriptionAdapter(val detailsList : List<>) : RecyclerView.Adapter<NewsDescriptionAdapter.newsDescription>() {
//    class newsDescription (itemView :View) : RecyclerView.ViewHolder(itemView){
//        val header = itemView.findViewById<TextView>(R.id.news_details_header_text)
//        val image = itemView.findViewById<ImageView>(R.id.news_details_image)
//        val image = itemView.findViewById<TextView>(R.id.news_details_image_description_text)
//        val descrText = itemView.findViewById<TextView>(R.id.description_news_text)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsDescription {
//    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_news_details,parent,false)
//        return newsDescription(itemView)
//    }
//
//    override fun getItemCount(): Int {
//        return detailsList.size
//    }
//
//    override fun onBindViewHolder(holder: newsDescription, position: Int) {
//    holder.header.text = detailsList[position].
//    }
//}