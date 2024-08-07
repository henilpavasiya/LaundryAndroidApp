package com.example.laundryapp.View.Home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.laundryapp.Model.HomeGridViewModel
import com.example.laundryapp.R
import com.example.laundryapp.ViewModel.HomeGridViewAdapter
import com.example.laundryapp.ViewModel.ViewPageAdapter
import com.example.laundryapp.databinding.FragmentHomeScreenBinding

class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {
    private lateinit var binding: FragmentHomeScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)

        binding.apply {
            val courseModelArrayList: ArrayList<HomeGridViewModel> = ArrayList()
            courseModelArrayList.add(HomeGridViewModel("Checkout Order", R.drawable.laundry_empty))
            courseModelArrayList.add(HomeGridViewModel("Order Details", R.drawable.orders))
            courseModelArrayList.add(HomeGridViewModel("How app works?", R.drawable.plans))
            courseModelArrayList.add(HomeGridViewModel("Plan", R.drawable.how))

            val adapter = HomeGridViewAdapter(requireContext(), courseModelArrayList)
            binding.idGVHome.adapter = adapter


            val image= listOf(
                R.drawable.slice1,
                R.drawable.slice2
            )
            val adapter2 = ViewPageAdapter(image)
                pvImage.adapter=adapter2
                pvImage.orientation= ViewPager2.ORIENTATION_HORIZONTAL // We also change orientation to verticle

                //we also move image automatically
                pvImage.beginFakeDrag()
                pvImage.fakeDragBy(-10f)
                pvImage.endFakeDrag()
        }
    }

    init {
        Log.d("Fragment", "HomeScreen Fragment")
    }
}
