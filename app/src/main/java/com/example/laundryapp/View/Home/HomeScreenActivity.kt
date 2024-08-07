package com.example.laundryapp.View.Home

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.laundryapp.R
import com.example.laundryapp.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeScreenFragment = HomeScreenFragment()
        val checkoutScreenFragment = CheckoutScreenFragment()
        val orderScreenFragment = OrderScreenFragment()
        val profileScreenFragment = ProfileScreenFragment()

        setCurrentFragment(homeScreenFragment)

        binding.bottomBar.setOnItemSelectedListener { // Bottom bar is the ID of the BottomNavigationView
            Log.d("Fragment", "working")

            when (it.itemId) {
                R.id.home -> setCurrentFragment(homeScreenFragment)
                R.id.checkout -> setCurrentFragment(checkoutScreenFragment)
                R.id.orderDetails -> setCurrentFragment(orderScreenFragment)
                R.id.profile -> setCurrentFragment(profileScreenFragment)
            }
            true
        }
    }

    fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment) // flFragment is the ID of the FrameLayout
            commit()
        }
    }

    fun selectBottomNavItem(itemId: Int) {
        binding.bottomBar.selectedItemId = itemId
    }
}
