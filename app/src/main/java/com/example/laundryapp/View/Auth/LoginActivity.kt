package com.example.laundryapp.View.Auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.laundryapp.MainActivity
import com.example.laundryapp.View.Home.HomeScreenActivity
import com.example.laundryapp.ViewModel.Auth.LoginViewModel
import com.example.laundryapp.databinding.ActivityLoginBinding
import kotlin.math.log

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        loginViewModel.navigateTo.observe(this, Observer {destination->
            destination?.let {
                try {
                    Intent(this@LoginActivity, it).also { intent ->
                        startActivity(intent)
                    }
                } catch (e: Exception) {
                    Log.e("LoginActivity", "Error starting activity $e")
                }
                finally {
                    loginViewModel.doneNavigating()
                }
            }

        })
        binding.apply {

            buttonForgotPassword.setOnClickListener {
              loginViewModel.onForgotPasswordClicked()
            }

            buttonLogin.setOnClickListener {
              loginViewModel.onLoginClicked()
            }

            buttonRegister.setOnClickListener {
               loginViewModel.onRegisterClicked()
            }
        }

    }
}