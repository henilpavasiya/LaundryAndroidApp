package com.example.laundryapp.ViewModel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.laundryapp.Model.HomeGridViewModel
import com.example.laundryapp.R
import com.example.laundryapp.databinding.FragmentHomeScreenBinding



class HomeGridViewAdapter(context: Context, courseModelArrayList: ArrayList<HomeGridViewModel>) :
    ArrayAdapter<HomeGridViewModel>(context, 0, courseModelArrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listItemView = LayoutInflater.from(context).inflate(R.layout.home_gridview, parent, false)
        }

        val courseModel: HomeGridViewModel? = getItem(position)
        val courseTV = listItemView!!.findViewById<TextView>(R.id.idTVCourse)
        val courseIV = listItemView.findViewById<ImageView>(R.id.idIVcourse)

        // Access properties directly
        courseTV.text = courseModel!!.grid_name
        courseIV.setImageResource(courseModel.imgid)
        return listItemView
    }
}

//class HomeGridViewAdapter(context: Context, courseModelArrayList: ArrayList<HomeGridViewModel>) :
//    ArrayAdapter<HomeGridViewModel>(context, 0, courseModelArrayList) {
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        var listItemView = convertView
//        if (listItemView == null) {
//            // Layout Inflater inflates each item to be displayed in GridView.
//            listItemView = LayoutInflater.from(context).inflate(R.layout.home_gridview, parent, false)
//        }
//
//        val courseModel: HomeGridViewModel? = getItem(position)
//        val courseTV = listItemView!!.findViewById<TextView>(R.id.idTVCourse)
//        val courseIV = listItemView.findViewById<ImageView>(R.id.idIVcourse)
//
//        courseTV.text = courseModel!!.getCourse_name()
//        courseIV.setImageResource(courseModel.getImgid())
//        return listItemView
//    }
//}