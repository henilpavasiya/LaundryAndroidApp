package com.example.laundryapp.ViewModel.Auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laundryapp.MainActivity
import com.example.laundryapp.View.Auth.ForgotPasswordActivity
import com.example.laundryapp.View.Auth.LoginActivity
import com.example.laundryapp.View.Auth.RegisterActivity
import com.example.laundryapp.View.Home.HomeScreenActivity

class LoginViewModel : ViewModel() {
    private val _navigateTo = MutableLiveData<Class<*>?>()
    val navigateTo: MutableLiveData<Class<*>?> get()= _navigateTo

    fun onForgotPasswordClicked() {
        _navigateTo.value = ForgotPasswordActivity::class.java
    }

    fun onLoginClicked() {
        _navigateTo.value = HomeScreenActivity::class.java
    }

    fun onRegisterClicked() {
        _navigateTo.value = RegisterActivity::class.java
    }

    fun doneNavigating() {
        _navigateTo.value = null
    }
}