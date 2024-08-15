package com.example.laundryapp.View.Extra

import ViewModelUserFactory
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.laundryapp.Repository.UserRepository
import com.example.laundryapp.View.Auth.LoginActivity
import com.example.laundryapp.View.Home.HomeScreenActivity
import com.example.laundryapp.ViewModel.AuthViewModel
import com.example.laundryapp.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userRepository= UserRepository()
        authViewModel = ViewModelProvider(this,ViewModelUserFactory(userRepository))[AuthViewModel::class.java]

        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)

            if(authViewModel.isUserLoggedIn()){
                startActivity(Intent(this@SplashActivity, HomeScreenActivity::class.java))
                finish()
            }
            else{
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                finish()
            }

        }
    }
}