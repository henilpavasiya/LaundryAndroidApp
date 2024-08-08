package com.example.laundryapp.View.Auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.laundryapp.MainActivity
import com.example.laundryapp.View.Home.HomeScreenActivity
import com.example.laundryapp.ViewModel.Auth.LoginViewModel
import com.example.laundryapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
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

        setupObservers()

        binding.apply {
            buttonForgotPassword.setOnClickListener {
                loginViewModel.onForgotPasswordClicked()
            }
            buttonLogin.setOnClickListener {
                val loginEmail = textFieldLoginEmail.text.toString()
                val loginPassword = textFieldLoginPassword.text.toString()
                loginViewModel.onLoginClicked(loginEmail, loginPassword)
            }
            buttonRegister.setOnClickListener {
                loginViewModel.onRegisterClicked()
            }
        }
    }

    private fun setupObservers() {
        loginViewModel.navigateTo.observe(this, Observer { destination ->
            destination?.let {
                Intent(this@LoginActivity, it).also { intent ->
                    startActivity(intent)
                    loginViewModel.doneNavigating()
                    finish()
                   }
            }
        })

        loginViewModel.loginStatus.observe(this, Observer {
            Toast.makeText(this@LoginActivity, it, Toast.LENGTH_LONG).show()
        })
    }

}
