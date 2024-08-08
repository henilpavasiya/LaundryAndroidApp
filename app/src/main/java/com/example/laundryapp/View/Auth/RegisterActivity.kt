package com.example.laundryapp.View.Auth

import ViewModelFactory
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.laundryapp.Repository.UserRepository
import com.example.laundryapp.ViewModel.AuthViewModel
import com.example.laundryapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userRepository = UserRepository()
        authViewModel = ViewModelProvider(this,ViewModelFactory(userRepository))[AuthViewModel::class.java]
        setupObservers()

        binding.apply {
            buttonRegisterLogin.setOnClickListener {
                Intent(this@RegisterActivity, LoginActivity::class.java).apply {
                    finish()
                }
            }
            buttonRegister.setOnClickListener {
                val registerEmail = textFieldRegisterEmail.text.toString()
                val registerPassword = textFieldRegisterPassword.text.toString()
                authViewModel.onRegisterClicked(registerEmail, registerPassword)
            }

            setSupportActionBar(commonAppBar.toolbar)

            // Enable back button support
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)

            // Handle back button click
            commonAppBar.toolbar.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }

    fun setupObservers() {
        authViewModel.navigateTo.observe(this, Observer {destination->
            destination?.let {
                Intent(this@RegisterActivity,it).also { intent->
                    startActivity(intent)
                    authViewModel.doneNavigating()
                    finish()
                }
            }
        })

        authViewModel.authStatus.observe(this, Observer{
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }



}