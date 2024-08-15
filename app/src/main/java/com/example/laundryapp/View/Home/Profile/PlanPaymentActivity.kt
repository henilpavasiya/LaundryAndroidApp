package com.example.laundryapp.View.Home.Profile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.laundryapp.R
import com.example.laundryapp.databinding.ActivityMyPlanBinding
import com.example.laundryapp.databinding.ActivityPlanPaymentBinding

class PlanPaymentActivity : AppCompatActivity() {
    lateinit var binding: ActivityPlanPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPlanPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            setSupportActionBar(commonAppBar.toolbar)
            commonAppBar.toolbarTitle.text = "Laundry Plan Payment"
            commonAppBar.toolbar.setNavigationOnClickListener {
                onBackPressed()
            }
        }


    }
}