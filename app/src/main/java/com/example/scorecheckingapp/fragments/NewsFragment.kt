package com.example.scorecheckingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.activity.MainActivity
import com.example.scorecheckingapp.adapter.NewsAdapter
import com.example.scorecheckingapp.dataClass.NewsDataClass
import com.example.scorecheckingapp.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    lateinit var binding: FragmentNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(layoutInflater,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).binding.bottomNavMenu.menu.getItem(2).isChecked = true

        val arrayForNews = ArrayList<NewsDataClass>()
        for (i in 1..10){
            arrayForNews.add(NewsDataClass(R.drawable.football,"Header Sample","        TODO(\"Not yet implemented\")\n        TODO(\"Not yet implemented\")\n        TODO(\"Not yet implemented\")\n        TODO(\"Not yet implemented\")\n"))
        }
        binding.newsRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
        binding.newsRecyclerView.adapter = NewsAdapter(arrayForNews)


    }


}