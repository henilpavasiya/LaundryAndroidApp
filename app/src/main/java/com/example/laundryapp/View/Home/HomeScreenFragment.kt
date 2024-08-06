package com.example.laundryapp.View.Home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.laundryapp.R
import com.example.laundryapp.databinding.FragmentHomeScreenBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {
   private lateinit var binding: FragmentHomeScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentHomeScreenBinding.inflate(layoutInflater)

        binding.apply {

        }

    }
    init {
        Log.d("Fragment","HomesScreen Fragment")
    }
}