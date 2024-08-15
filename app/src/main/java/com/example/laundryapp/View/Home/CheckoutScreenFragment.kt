package com.example.laundryapp.View.Home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laundryapp.Model.HomeProductModel
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
            HomeProductModel("Apron", 0, R.drawable.apron),
            HomeProductModel("Bedspread", 0, R.drawable.bedspread),
            HomeProductModel("Blazer", 0, R.drawable.blazer),
            HomeProductModel("Blazer Lino", 0, R.drawable.blazerlino),
            HomeProductModel("Coat", 0, R.drawable.coat),
            HomeProductModel("Curtain", 0, R.drawable.curtain),
            HomeProductModel("Dress", 0, R.drawable.dress),
            HomeProductModel("Handkerchief", 0, R.drawable.handkerchief),
            HomeProductModel("Jacket", 0, R.drawable.jacket),
            HomeProductModel("Jeans", 0, R.drawable.jeans),
            HomeProductModel("Mattress Topper", 0, R.drawable.mattress_topper),
            HomeProductModel("Napkin", 0, R.drawable.napkin),
            HomeProductModel("Pantalon", 0, R.drawable.pantalon),
            HomeProductModel("Pantalon Falda", 0, R.drawable.pantalonfalda),
            HomeProductModel("Pantalon Lino", 0, R.drawable.pantalonlino),
            HomeProductModel("Pillow Cover", 0, R.drawable.pillow_cover),
            HomeProductModel("Product Basket", 0, R.drawable.product_basket),
            HomeProductModel("Scarf", 0, R.drawable.scarf),
            HomeProductModel("Shirt", 0, R.drawable.shirt),
            HomeProductModel("Short", 0, R.drawable.resource_short),
            HomeProductModel("Skirt", 0, R.drawable.skirt),
            HomeProductModel("Suit", 0, R.drawable.suit),
            HomeProductModel("T-shirt", 0, R.drawable.t_shirt),
            HomeProductModel("Table Cloths", 0, R.drawable.tablecloths),
            HomeProductModel("Tie", 0, R.drawable.tie),
        )
        val homeProductViewAdapter = HomeProductViewAdapter(productList)

        binding.apply {
            rvProduct.adapter=homeProductViewAdapter
            rvProduct.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    init {
        Log.d("Fragment", "CheckScreen Fragment")
    }
}