//package com.example.scorecheckingapp.adapter
//
//import android.net.Uri
//import android.text.Html
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.webkit.WebView
//import android.widget.TextView
//import android.widget.VideoView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.scorecheckingapp.API.watchApi.watch
//import com.example.scorecheckingapp.API.watchApi.watchItem
//import com.example.scorecheckingapp.R
//import org.jsoup.Jsoup
//import org.w3c.dom.Element
//import java.net.URI
//
//class WatchAdapter(val watchArray: List<watchItem>) :
//    RecyclerView.Adapter<WatchAdapter.watchViewHolder>() {
//    class watchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val video = itemView.findViewById<VideoView>(R.id.watch_video)
//        val videoTitle = itemView.findViewById<TextView>(R.id.watch_video_title)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): watchViewHolder {
//        val itemView =
//            LayoutInflater.from(parent.context).inflate(R.layout.list_watch, parent, false)
//        return watchViewHolder(itemView)
//    }
//
//    override fun getItemCount(): Int {
//        return watchArray.size
//    }
//
//    override fun onBindViewHolder(holder: watchViewHolder, position: Int) {
//
////        Log.d("Videp", Jsoup.connect(watchArray[0].embed).get())
//
//
//
//    //        Log.d("Video",uri.toString())
//        /*holder.video.setVideoURI(uri)
//        holder.video.requestFocus()
//        holder.video.start()*/
////        holder.videoTitle.text = watchArray[position].title
//    }
//}