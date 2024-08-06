package com.example.laundryapp.View.Home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.laundryapp.databinding.FragmentProfileScreenBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileScreenFragment : Fragment() {
    private lateinit var binding: FragmentProfileScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileScreenBinding.inflate(layoutInflater)
        binding.apply {

        }
    }
}