package com.example.laundryapp.View.Auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.laundryapp.ViewModel.Auth.RegisterViewModel
import com.example.laundryapp.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
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
                registerViewModel.onRegisterClicked(registerEmail, registerPassword)
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
        registerViewModel.navigateTo.observe(this, Observer {destination->
            destination?.let {
                Intent(this@RegisterActivity,it).also { intent->
                     startActivity(intent)
                    registerViewModel.doneNavigating()
                    finish()
                }
            }
        })

        registerViewModel.loginStatus.observe(this, Observer{
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }



}