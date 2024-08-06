package com.example.laundryapp.View.Home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.laundryapp.databinding.FragmentOrderScreenBinding

/**
 * A simple [Fragment] subclass.
 * Use the [OrderScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderScreenFragment : Fragment() {
    private lateinit var binding: FragmentOrderScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentOrderScreenBinding.inflate(layoutInflater)
        binding.apply {

        }
    }
}