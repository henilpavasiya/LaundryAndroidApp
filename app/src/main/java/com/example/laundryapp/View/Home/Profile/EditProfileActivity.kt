package com.example.laundryapp.View.Home.Profile

import ViewModelUserFactory
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.laundryapp.R
import com.example.laundryapp.Repository.UserRepository
import com.example.laundryapp.ViewModel.AuthViewModel
import com.example.laundryapp.databinding.ActivityEditProfileBinding


class EditProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditProfileBinding
    lateinit var authViewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userRepository = UserRepository()
        authViewModel =
            ViewModelProvider(this, ViewModelUserFactory(userRepository))[AuthViewModel::class.java]

        authViewModel.userName.observe(this, Observer { userName ->
            binding.textViewName.text = userName
        })

        authViewModel.userEmail.observe(this, Observer { userEmail ->
            binding.textViewEmail.text = userEmail
        })

        authViewModel.userImageUri.observe(this, Observer { uri ->
            uri?.let {
                Glide.with(this).load(uri).into(binding.imageViewProfile)
            } ?: run {
                binding.imageViewProfile.setImageResource(R.drawable.account)
            }
        })

        authViewModel.userImageUri.observe(this, Observer { uri ->
            Log.d("EditProfileActivity", "Loaded Image URI: $uri") // Add this line to debug URI

            uri?.let {
                Glide.with(this)
                    .load(it)
                    .placeholder(R.drawable.account) // Show placeholder while loading
                    .error(R.drawable.myprofile) // Show error image if loading fails
                    .into(binding.imageViewProfile)
            } ?: run {
                binding.imageViewProfile.setImageResource(R.drawable.account)
            }
        })

        authViewModel.loadUserData()

        binding.apply {
            setSupportActionBar(commonAppBar.toolbar)
            commonAppBar.toolbarTitle.text = "My Profile"
            // Handle back button click
            commonAppBar.toolbar.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }
}