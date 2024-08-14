package com.example.laundryapp.View.Home.Profile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.laundryapp.R
import com.example.laundryapp.databinding.ActivityMyPlanBinding

class MyPlanActivity : AppCompatActivity() {
    lateinit var binding:ActivityMyPlanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMyPlanBinding.inflate(layoutInflater)
        setContentView(binding.root)
       binding.apply {
           setSupportActionBar(commonAppBar.toolbar)
           // Handle back button click
           commonAppBar.toolbar.setNavigationOnClickListener {
               onBackPressed()
           }
       }
    }
}