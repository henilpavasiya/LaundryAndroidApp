package com.example.laundryapp.ViewModel.Auth

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laundryapp.MainActivity
import com.example.laundryapp.View.Auth.ForgotPasswordActivity
import com.example.laundryapp.View.Auth.LoginActivity
import com.example.laundryapp.View.Auth.RegisterActivity
import com.example.laundryapp.View.Home.HomeScreenActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {
    private val _navigateTo = MutableLiveData<Class<*>?>()
    val navigateTo: LiveData<Class<*>?> get() = _navigateTo

    private val _loginStatus = MutableLiveData<String>()
    val loginStatus: LiveData<String> = _loginStatus

    private val auth = FirebaseAuth.getInstance()

    fun onForgotPasswordClicked() {
        _navigateTo.value = ForgotPasswordActivity::class.java
    }

    fun onLoginClicked(loginEmail: String, loginPassword: String) {
        if (loginEmail.isNotEmpty() && loginPassword.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    auth.signInWithEmailAndPassword(loginEmail, loginPassword).await()
                    withContext(Dispatchers.Main) {
                        _loginStatus.value="Login Successful"
                        _navigateTo.value = HomeScreenActivity::class.java
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        _loginStatus.value = e.message ?: "Login Failed"
                    }
                }
            }
        } else {
            _loginStatus.value = "Email and Password cannot be empty"
        }
    }

    fun onRegisterClicked() {
        _navigateTo.value = RegisterActivity::class.java
    }

    fun doneNavigating() {
        _navigateTo.value = null
    }


}