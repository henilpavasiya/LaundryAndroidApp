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
import com.example.laundryapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userRepository = UserRepository()
        authViewModel = ViewModelProvider(this,ViewModelFactory(userRepository))[AuthViewModel::class.java]

        setupObservers()

        binding.apply {
            buttonForgotPassword.setOnClickListener {
                authViewModel.onForgotPasswordClicked()
            }
            buttonLogin.setOnClickListener {
                val loginEmail = textFieldLoginEmail.text.toString()
                val loginPassword = textFieldLoginPassword.text.toString()
                authViewModel.onLoginClicked(loginEmail, loginPassword)
            }
            buttonRegister.setOnClickListener {
                authViewModel.onRegisterSimpleClicked()
            }
        }
    }

    private fun setupObservers() {
        authViewModel.navigateTo.observe(this, Observer { destination ->
            destination?.let {
                Intent(this@LoginActivity, it).also { intent ->
                    startActivity(intent)
                    authViewModel.doneNavigating()
                    finish()
                   }
            }
        })

        authViewModel.authStatus.observe(this, Observer {
            Toast.makeText(this@LoginActivity, it, Toast.LENGTH_LONG).show()
        })
    }

}
