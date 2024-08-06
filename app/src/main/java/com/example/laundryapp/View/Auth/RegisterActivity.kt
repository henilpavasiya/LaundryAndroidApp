package com.example.laundryapp.View.Auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.laundryapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            buttonRegisterLogin.setOnClickListener{
                Intent(this@RegisterActivity, LoginActivity::class.java).apply {
                    finish()
                }
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
}