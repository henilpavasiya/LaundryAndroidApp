package com.example.laundryapp.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.laundryapp.databinding.FragmentOrderBinding
import com.example.laundryapp.databinding.FragmentOrderScreenBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrderScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderScreenFragment : Fragment() {
    private lateinit var binding: FragmentOrderScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentOrderScreenBinding.inflate(layoutInflater)
        binding.apply {

        }
    }
}