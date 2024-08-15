package com.example.laundryapp.View.Components

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laundryapp.Model.HomeProductViewModel
import com.example.laundryapp.R

class HomeProductViewAdapter(var homeProductViewModel: List<HomeProductViewModel>) :
    RecyclerView.Adapter<HomeProductViewAdapter.HomeProductViewHolder>() {
    inner class HomeProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productName: TextView = itemView.findViewById(R.id.textViewProductName)
        var productQuantity: TextView = itemView.findViewById(R.id.textViewProductQuantityNumber)
        var productImage: ImageView = itemView.findViewById(R.id.imageViewProductImage)
        var productQuantityNumber: TextView = itemView.findViewById(R.id.textViewProductQuantityPNNumber)
        var buttonPlus:Button = itemView.findViewById(R.id.appCompatButtonPlus)
        var buttonMinus:Button = itemView.findViewById(R.id.appCompatButtonMinus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeProductViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_productview, parent, false)
        return HomeProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return homeProductViewModel.size
    }

    override fun onBindViewHolder(holder: HomeProductViewHolder, position: Int) {
        holder.apply {
            buttonPlus.setOnClickListener(){
                homeProductViewModel[position].productQuantity++
                productQuantity.text = homeProductViewModel[position].productQuantity.toString()
                productQuantityNumber.text = productQuantity.text
                Log.d("buttonPlus","${homeProductViewModel[position].productQuantity}")
            }
            buttonMinus.setOnClickListener{
                if(homeProductViewModel[position].productQuantity>0) {
                    homeProductViewModel[position].productQuantity--
                    productQuantity.text = homeProductViewModel[position].productQuantity.toString()
                    productQuantityNumber.text = productQuantity.text
                    Log.d("buttonMinus", "${homeProductViewModel[position].productQuantity}")
                }
            }

            productName.text = homeProductViewModel[position].productName

            productImage.setImageResource(homeProductViewModel[position].productImage)


            Log.d("buttonMinus::", "${productQuantity.text}")
        }
    }
}

