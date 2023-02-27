//package com.example.scorecheckingapp.fragments.News
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import com.example.scorecheckingapp.API.NewsApi.NewsDetailsInterface
//import com.example.scorecheckingapp.API.NewsApi.NewsInterface
//import com.example.scorecheckingapp.databinding.ListNewsDetailsBinding
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//class NewsDetailsFragment : Fragment() {
//
//    lateinit var binding: ListNewsDetailsBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = ListNewsDetailsBinding.inflate(layoutInflater,container,false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }
//
//    private fun getNewsDetails() {
//        val retrofit = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl("https://livescore6.p.rapidapi.com/news/v2/")
//            .build()
//            .create(NewsDetailsInterface::class.java)
//
//        val retrofitNews = retrofit.getNewsDetails(
//
//            "b72713c116msh3868c671703c21dp15679bjsn6f00e94a7fc0",
//            "livescore6.p.rapidapi.com"
//        )
//
//        retrofitNews?.enqueue
//}