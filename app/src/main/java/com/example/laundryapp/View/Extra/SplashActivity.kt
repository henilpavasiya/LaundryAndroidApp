package com.example.laundryapp.View.Extra

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.laundryapp.MainActivity
import com.example.laundryapp.View.Auth.LoginActivity
import com.example.laundryapp.View.Home.HomeScreenActivity
import com.example.laundryapp.databinding.ActivitySplashBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            auth=FirebaseAuth.getInstance()

            if(auth.currentUser == null){
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                finish()
            }
            else{
                startActivity(Intent(this@SplashActivity, HomeScreenActivity::class.java))
                finish()
            }

        }
    }
}