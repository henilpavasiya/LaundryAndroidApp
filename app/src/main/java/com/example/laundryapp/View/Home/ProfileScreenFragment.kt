package com.example.laundryapp.View.Home

import ViewModelFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.laundryapp.R
import com.example.laundryapp.Repository.UserRepository
import com.example.laundryapp.ViewModel.AuthViewModel
import com.example.laundryapp.databinding.FragmentProfileScreenBinding

class ProfileScreenFragment : Fragment(R.layout.fragment_profile_screen) {
    private lateinit var binding: FragmentProfileScreenBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Bind the view directly from the view provided by onViewCreated
        binding = FragmentProfileScreenBinding.bind(view)
//        binding = FragmentProfileScreenBinding.inflate(layoutInflater)

        val userRepository = UserRepository()
        authViewModel = ViewModelProvider(this, ViewModelFactory(userRepository))[AuthViewModel::class.java]

        binding.apply {
            buttonLogout.setOnClickListener {
                Log.d("Logout", "Logout is working")
                authViewModel.logout()
            }
            buttonAlertDialog.setOnClickListener {
                Log.d("AlertDialog", "AlertDialog is working")
            }
        }
    }

    init {
        Log.d("Fragment", "ProfileScreen Fragment")
    }
}
