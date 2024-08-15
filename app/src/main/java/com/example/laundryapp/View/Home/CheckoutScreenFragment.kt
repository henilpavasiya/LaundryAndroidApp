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
            HomeProductViewModel("Apron", 0, R.drawable.apron),
            HomeProductViewModel("Bedspread", 0, R.drawable.bedspread),
            HomeProductViewModel("Blazer", 0, R.drawable.blazer),
            HomeProductViewModel("Blazer Lino", 0, R.drawable.blazerlino),
            HomeProductViewModel("Coat", 0, R.drawable.coat),
            HomeProductViewModel("Curtain", 0, R.drawable.curtain),
            HomeProductViewModel("Dress", 0, R.drawable.dress),
            HomeProductViewModel("Handkerchief", 0, R.drawable.handkerchief),
            HomeProductViewModel("Jacket", 0, R.drawable.jacket),
            HomeProductViewModel("Jeans", 0, R.drawable.jeans),
            HomeProductViewModel("Mattress Topper", 0, R.drawable.mattress_topper),
            HomeProductViewModel("Napkin", 0, R.drawable.napkin),
            HomeProductViewModel("Pantalon", 0, R.drawable.pantalon),
            HomeProductViewModel("Pantalon Falda", 0, R.drawable.pantalonfalda),
            HomeProductViewModel("Pantalon Lino", 0, R.drawable.pantalonlino),
            HomeProductViewModel("Pillow Cover", 0, R.drawable.pillow_cover),
            HomeProductViewModel("Product Basket", 0, R.drawable.product_basket),
            HomeProductViewModel("Scarf", 0, R.drawable.scarf),
            HomeProductViewModel("Shirt", 0, R.drawable.shirt),
            HomeProductViewModel("Short", 0, R.drawable.resource_short),
            HomeProductViewModel("Skirt", 0, R.drawable.skirt),
            HomeProductViewModel("Suit", 0, R.drawable.suit),
            HomeProductViewModel("T-shirt", 0, R.drawable.t_shirt),
            HomeProductViewModel("Table Cloths", 0, R.drawable.tablecloths),
            HomeProductViewModel("Tie", 0, R.drawable.tie),
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