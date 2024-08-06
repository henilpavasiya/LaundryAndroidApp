package com.example.laundryapp.View

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.laundryapp.MainActivity
import com.example.laundryapp.R
import com.example.laundryapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            buttonForgotPassword.setOnClickListener {
                try{
                    Intent(this@LoginActivity,ForgotPasswordActivity::class.java).also {
                        startActivity(it)
                    }
                }
                catch (e:Exception){
                    Log.e("LoginActivity", "Error starting activity", e)
                }
            }

            buttonLogin.setOnClickListener {
                try {
                    Intent(this@LoginActivity, MainActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                } catch (e: Exception) {
                    Log.e("LoginActivity", "Error starting activity", e)
                }
            }

            buttonRegister.setOnClickListener {
                try {
                    Intent(this@LoginActivity, RegisterActivity::class.java).also {
                        startActivity(it)
                    }
                } catch (e: Exception) {
                    Log.e("LoginActivity", "Error starting activity", e)
                }
            }
        }

    }
}