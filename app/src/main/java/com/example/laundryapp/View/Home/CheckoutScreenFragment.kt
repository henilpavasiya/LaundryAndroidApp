package com.example.laundryapp.View.Home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laundryapp.Model.HomeProductViewModel
import com.example.laundryapp.R
import com.example.laundryapp.View.Components.HomeProductViewAdapter
import com.example.laundryapp.databinding.FragmentCheckoutScreenBinding

/**
 * A simple [Fragment] subclass.
 * Use the [CheckoutScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckoutScreenFragment : Fragment(R.layout.fragment_checkout_screen) {
    private lateinit var binding: FragmentCheckoutScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCheckoutScreenBinding.bind(view)

        var productList = mutableListOf(
            HomeProductViewModel("T-shirt", 2, R.drawable.how),
            HomeProductViewModel("Pant", 1, R.drawable.orders),
            HomeProductViewModel("T-shirt", 2, R.drawable.how),
            HomeProductViewModel("Pant", 1, R.drawable.orders),
        )
        val homeProductViewAdapter=HomeProductViewAdapter(productList)

        binding.apply {
            rvProduct.adapter=homeProductViewAdapter
            rvProduct.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    init {
        Log.d("Fragment", "CheckScreen Fragment")
    }
}