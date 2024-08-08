package com.example.laundryapp.View.Home

import ViewModelFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.laundryapp.R
import com.example.laundryapp.Repository.UserRepository
import com.example.laundryapp.ViewModel.AuthViewModel
import com.example.laundryapp.databinding.FragmentProfileScreenBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileScreenFragment : Fragment(R.layout.fragment_profile_screen) {
    private lateinit var binding: FragmentProfileScreenBinding
    lateinit var authViewModel:AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileScreenBinding.inflate(layoutInflater)
        val userRepository = UserRepository()
        authViewModel =
            ViewModelProvider(this, ViewModelFactory(userRepository))[AuthViewModel::class.java]

        binding.apply {
            buttonLogout.setOnClickListener(){
                Log.d("Logout","Logout is working")
                authViewModel.logout()
            }
        }
    }
    init {
        Log.d("Fragment","ProfileScreen Fragment")
    }
}