package com.example.laundryapp.View.Components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            productName.text = homeProductViewModel[position].productName
            productQuantity.text = homeProductViewModel[position].productQuantity.toString()
            productImage.setImageResource(homeProductViewModel[position].productImage)
//            productImage = homeProductViewModel[position].productImage
        }
    }
}

