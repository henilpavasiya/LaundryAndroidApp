package com.example.laundryapp.ViewModel

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.laundryapp.Model.HomeGridViewModel
import com.example.laundryapp.R

class HomeGridViewAdapter(
    context: Context,
    private val courseModelArrayList: ArrayList<HomeGridViewModel>,
    private val onItemClick: (position: Int) -> Unit
) : ArrayAdapter<HomeGridViewModel>(context, 0, courseModelArrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            // Inflate each item to be displayed in GridView
            listItemView = LayoutInflater.from(context).inflate(R.layout.home_gridview, parent, false)
        }

        val courseModel: HomeGridViewModel? = getItem(position)
        val courseTV = listItemView!!.findViewById<TextView>(R.id.idTVCourse)
        val courseIV = listItemView.findViewById<ImageView>(R.id.idIVcourse)
        val selectedGridView=listItemView.findViewById<LinearLayout>(R.id.buttonGrid)

        // Set the properties
        courseTV.text = courseModel!!.grid_name
        courseIV.setImageResource(courseModel.imgid)

        // Set an OnClickListener for the grid item
        selectedGridView.setOnClickListener {
            onItemClick(position)
        }

        return listItemView
    }
}
