package com.example.laundryapp.View.Home.Profile

import ViewModelPlanFactory
import ViewModelUserFactory
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.laundryapp.R
import com.example.laundryapp.Repository.PlanRepository
import com.example.laundryapp.ViewModel.MyPlanViewModel
import com.example.laundryapp.databinding.ActivityMyPlanBinding

class MyPlanActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyPlanBinding
    lateinit var myPlanViewModel: MyPlanViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMyPlanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val planRepository = PlanRepository()
        myPlanViewModel = ViewModelProvider(this,ViewModelPlanFactory(planRepository))[MyPlanViewModel::class.java]



        binding.apply {
            buttonBuyLaundryPlan.setOnClickListener() {
                Intent(this@MyPlanActivity, PlanPaymentActivity::class.java).let {
                    startActivity(it)
                }
            }

            button5KG.setOnClickListener() {
                button5KG.setCardBackgroundColor(resources.getColor(R.color.colorPrimaryLight))
                button10KG.setCardBackgroundColor(resources.getColor(R.color.white))

            }
            button10KG.setOnClickListener() {
                button10KG.setCardBackgroundColor(resources.getColor(R.color.colorPrimaryLight))
                button5KG.setCardBackgroundColor(resources.getColor(R.color.white))
            }

            setSupportActionBar(commonAppBar.toolbar)
            commonAppBar.toolbarTitle.text = "My Plan"
            commonAppBar.toolbar.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }
}
