package com.example.laundryapp.View.Home.Profile

import ViewModelPlanFactory
import ViewModelUserFactory
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
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
        myPlanViewModel = ViewModelProvider(
            this,
            ViewModelPlanFactory(planRepository)
        )[MyPlanViewModel::class.java]

        setupObservers()

        binding.apply {
            buttonBuyLaundryPlan.setOnClickListener() {

            }

            button5KG.setOnClickListener() {
                button5KG.setCardBackgroundColor(resources.getColor(R.color.colorPrimaryLight))
                button10KG.setCardBackgroundColor(resources.getColor(R.color.white))

                val planLastDate = "1"
                val planPrice = 100
                val planStatus = true
                val planTitle = "5KG Laundry Plan"
                myPlanViewModel.buyLaundryPlan(planLastDate,planPrice,planStatus,planTitle)

            }
            button10KG.setOnClickListener() {
                button10KG.setCardBackgroundColor(resources.getColor(R.color.colorPrimaryLight))
                button5KG.setCardBackgroundColor(resources.getColor(R.color.white))


                val planLastDate = "1"
                val planPrice = 160
                val planStatus = true
                val planTitle = "10KG Laundry Plan"
                myPlanViewModel.buyLaundryPlan(planLastDate,planPrice,planStatus,planTitle)
            }

            setSupportActionBar(commonAppBar.toolbar)
            commonAppBar.toolbarTitle.text = "My Plan"
            commonAppBar.toolbar.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }

    private fun setupObservers() {

        myPlanViewModel.planTitle.observe(this, Observer {

        })

        myPlanViewModel.navigateTo.observe(this, Observer {
            Intent(this@MyPlanActivity, PlanPaymentActivity::class.java).let {
                startActivity(it)
            }
        })


        myPlanViewModel.authStatus.observe(this, Observer {
            Toast.makeText(this@MyPlanActivity, it, Toast.LENGTH_LONG).show()
        })
    }
}
