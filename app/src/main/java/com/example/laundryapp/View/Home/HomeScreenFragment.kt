package com.example.laundryapp.View.Home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.laundryapp.Model.HomeGridModel
import com.example.laundryapp.R
import com.example.laundryapp.View.Components.HomeGridViewAdapter
import com.example.laundryapp.View.Components.ViewPageAdapter
import com.example.laundryapp.databinding.FragmentHomeScreenBinding

class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {
    private lateinit var binding: FragmentHomeScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)

        val courseModelArrayList: ArrayList<HomeGridModel> = ArrayList()
        courseModelArrayList.add(HomeGridModel("Checkout Order", R.drawable.laundry_empty))
        courseModelArrayList.add(HomeGridModel("Order Details", R.drawable.orders))
        courseModelArrayList.add(HomeGridModel("How app works?", R.drawable.plans))
        courseModelArrayList.add(HomeGridModel("Plan", R.drawable.how))

        val adapter = HomeGridViewAdapter(requireContext(), courseModelArrayList) { position ->
            // Handle item clicks to navigate to the corresponding fragment
            val activity = activity as HomeScreenActivity
            when (position) {
                0 -> {
                    activity.setCurrentFragment(CheckoutScreenFragment())
                    activity.selectBottomNavItem(R.id.checkout)
                }
                1 -> {
                    activity.setCurrentFragment(OrderScreenFragment())
                    activity.selectBottomNavItem(R.id.orderDetails)
                }
                2 -> {
                    activity.setCurrentFragment(OrderScreenFragment())
                    activity.selectBottomNavItem(R.id.profile) // Update if you have a dedicated nav item
                }
                3 -> {
                    activity.setCurrentFragment(ProfileScreenFragment())
                    activity.selectBottomNavItem(R.id.profile)
                }
            }
        }

        binding.idGVHome.adapter = adapter

        val images = listOf(
            R.drawable.slice1,
            R.drawable.slice2
        )
        val adapter2 = ViewPageAdapter(images)
        binding.pvImage.adapter = adapter2
        binding.pvImage.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // Move images automatically
        binding.pvImage.beginFakeDrag()
        binding.pvImage.fakeDragBy(-10f)
        binding.pvImage.endFakeDrag()
    }

    init {
        Log.d("Fragment", "HomeScreen Fragment")
    }
}
