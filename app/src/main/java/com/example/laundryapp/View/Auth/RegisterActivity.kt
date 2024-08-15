package com.example.laundryapp.View.Auth

import ViewModelUserFactory
import android.app.Activity
import android.content.Intent
import android.net.Uri
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
    private var selectedImageUri: Uri? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userRepository = UserRepository()
        authViewModel =
            ViewModelProvider(this, ViewModelUserFactory(userRepository))[AuthViewModel::class.java]
        setupObservers()

        binding.apply {
            buttonRegisterLogin.setOnClickListener {
                Intent(this@RegisterActivity, LoginActivity::class.java).apply {
                    startActivity(this)
                    finish()
                }
            }
            buttonRegister.setOnClickListener {
                val registerEmail = textFieldRegisterEmail.text.toString()
                val registerPassword = textFieldRegisterPassword.text.toString()
                val registerName = textFieldRegisterName.text.toString()
                selectedImageUri?.let {uri->
                    authViewModel.onRegisterClicked(
                        uri,
                        registerName,
                        registerEmail,
                        registerPassword
                    )
                } ?: run {
                    Toast.makeText(this@RegisterActivity, "Please select an image", Toast.LENGTH_LONG).show()
                }


            }

            imageView.setOnClickListener{
                Intent(Intent.ACTION_GET_CONTENT).also {
                    it.type="image/*"
                    this@RegisterActivity.startActivityForResult(it,0)
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

    fun setupObservers() {
        authViewModel.navigateTo.observe(this, Observer { destination ->
            destination?.let {
                Intent(this@RegisterActivity, it).also { intent ->
                    startActivity(intent)
                    authViewModel.doneNavigating()
                    finish()
                }
            }
        })

        authViewModel.authStatus.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            val uri: Uri? = data?.data
            if (uri != null) {
                selectedImageUri = uri
                binding.imageView.setImageURI(uri)
            } else {
                Toast.makeText(this, "Image selection failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

}