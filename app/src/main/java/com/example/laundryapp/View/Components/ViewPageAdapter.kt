package com.example.laundryapp.View.Components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.laundryapp.R

class ViewPageAdapter(val images : List<Int>): RecyclerView.Adapter<ViewPageAdapter.ViewPagerViewerHolder>() {
    inner class ViewPagerViewerHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var ivImage: ImageView =itemView.findViewById(R.id.ivImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewerHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager,parent,false)
        return ViewPagerViewerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewerHolder, position: Int) {
        val curImage = images[position]
        holder.ivImage.setImageResource(curImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}
