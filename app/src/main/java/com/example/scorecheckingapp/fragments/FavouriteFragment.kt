package com.example.scorecheckingapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scorecheckingapp.activity.MainActivity
import com.example.scorecheckingapp.adapter.FavouriteAdapter
import com.example.scorecheckingapp.dataClass.ListFavouriteId
import com.example.scorecheckingapp.dataClass.ViewFavouriteClass
import com.example.scorecheckingapp.databinding.FragmentFavouriteBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FavouriteFragment() : Fragment() {

    lateinit var database: DatabaseReference
    lateinit var binding: FragmentFavouriteBinding
    private var dataFavourite = arrayListOf<ViewFavouriteClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavouriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).binding.bottomNavMenu.menu.getItem(1).isChecked = true
        (activity as MainActivity).setTitle("Favourite")
        binding.favouriteRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val user = FirebaseAuth.getInstance().currentUser!!.uid
        val db = FirebaseDatabase.getInstance().getReference("users/$user/listId")

        database = Firebase.database.reference
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (i in snapshot.children) {
                        val listData = i.getValue(ViewFavouriteClass::class.java)
                        dataFavourite.add(listData!!)
                        binding.progressBar.visibility = View.GONE
                        binding.favouriteRecyclerView.adapter =
                            FavouriteAdapter(requireContext(), dataFavourite)
                        Log.d("snapshot", dataFavourite.toString())
                    }
                } else {
                    binding.progressBar.visibility = View.GONE
                    binding.favouriteRecyclerView.adapter = null
                    binding.favouriteText.text = "Add Favourite Matches"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Error", error.details)
            }
        })
    }

    /*fun getFavouriteApi(i: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://livescore6.p.rapidapi.com/matches/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FavouriteApiInterface::class.java)

        val retrofitResponse = retrofit.getData(
            "0556ba5f2bmshb44144c24b34dd9p19186cjsne46d41378f92",
            "livescore6.p.rapidapi.com",
            i,
            "soccer"
        )

        retrofitResponse.enqueue(object : Callback<favourite?> {
            override fun onResponse(call: Call<favourite?>, response: Response<favourite?>) {
                val responseBody = response.body()!!
                Log.d("Seridnsd", responseBody.toString())
                binding.favouriteRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                binding.favouriteRecyclerView.adapter = FavouriteAdapter(requireContext(), listOf(responseBody) )
            }

            override fun onFailure(call: Call<favourite?>, t: Throwable) {
                Log.d("Failure", t.localizedMessage)
            }
        })
    }
*/
}


/* val user = FirebaseAuth.getInstance().currentUser!!.uid
       val db = FirebaseDatabase.getInstance().getReference("users/$user/listId")
       db.addValueEventListener(object : ValueEventListener {
           override fun onDataChange(snapshot: DataSnapshot) {
               for (item in snapshot.children) {
                   val listData = item.getValue(ListFavouriteId::class.java)
                   eidList.plus(listData)
                   Log.d("list", eidList.toString())
               }
           }

           override fun onCancelled(error: DatabaseError) {
               Log.d("sd", "sad")
           }
       }

private fun userData() {
    val user = FirebaseAuth.getInstance().currentUser!!.uid
    val datab = FirebaseDatabase.getInstance()
    val list = eidList.plus(eid)
    datab.getReference("users/$user").child("listId").push().setValue(eid)
    for (i in list) {
        Log.d("FavouriteSize", i.length.toString())
        getFavouriteApi(i)
        Log.d("Favourite", i)
    }
}*/
