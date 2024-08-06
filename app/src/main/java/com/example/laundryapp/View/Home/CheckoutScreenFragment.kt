package com.example.laundryapp.View.Home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.laundryapp.databinding.FragmentCheckoutScreenBinding

/**
 * A simple [Fragment] subclass.
 * Use the [CheckoutScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckoutScreenFragment : Fragment() {
    private lateinit var binding: FragmentCheckoutScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentCheckoutScreenBinding.inflate(layoutInflater)
        binding.apply {

        }
    }
}