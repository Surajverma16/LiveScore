package com.example.scorecheckingapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.databinding.ActivityCricketBinding

class CricketActivity : AppCompatActivity() {
    lateinit var binding: ActivityCricketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCricketBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        setContentView(binding.root)
    }
}