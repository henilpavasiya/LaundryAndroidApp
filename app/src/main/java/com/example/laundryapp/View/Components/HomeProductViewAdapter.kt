package com.example.laundryapp.View.Components

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laundryapp.Model.HomeProductModel
import com.example.laundryapp.R

class HomeProductViewAdapter(var homeProductModel: List<HomeProductModel>) :
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
        return homeProductModel.size
    }

    override fun onBindViewHolder(holder: HomeProductViewHolder, position: Int) {
        holder.apply {
            buttonPlus.setOnClickListener(){
                homeProductModel[position].productQuantity++
                productQuantity.text = homeProductModel[position].productQuantity.toString()
                productQuantityNumber.text = productQuantity.text
                Log.d("buttonPlus","${homeProductModel[position].productQuantity}")
            }
            buttonMinus.setOnClickListener{
                if(homeProductModel[position].productQuantity>0) {
                    homeProductModel[position].productQuantity--
                    productQuantity.text = homeProductModel[position].productQuantity.toString()
                    productQuantityNumber.text = productQuantity.text
                    Log.d("buttonMinus", "${homeProductModel[position].productQuantity}")
                }
            }

            productName.text = homeProductModel[position].productName

            productImage.setImageResource(homeProductModel[position].productImage)


            Log.d("buttonMinus::", "${productQuantity.text}")
        }
    }
}

