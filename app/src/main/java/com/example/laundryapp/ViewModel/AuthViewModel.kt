package com.example.laundryapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laundryapp.Repository.UserRepository
import com.example.laundryapp.View.Auth.ForgotPasswordActivity
import com.example.laundryapp.View.Auth.RegisterActivity
import com.example.laundryapp.View.Home.HomeScreenActivity
import kotlinx.coroutines.launch

class AuthViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _navigateTo = MutableLiveData<Class<*>?>()
    val navigateTo: LiveData<Class<*>?> get() = _navigateTo

    private val _authStatus = MutableLiveData<String>()
    val authStatus: LiveData<String> get() = _authStatus

    fun onLoginClicked(loginEmail: String, loginPassword: String) {
        if (loginEmail.isNotEmpty() && loginPassword.isNotEmpty()) {
            viewModelScope.launch {
                var result = userRepository.loginUser(loginEmail, loginPassword)
                _authStatus.value = result
                if (result == "Login Successful") {
                    _navigateTo.value = HomeScreenActivity::class.java
                }
            }
        } else {
            _authStatus.value = "Email and Password cannot be empty"
        }
    }

    fun onRegisterClicked(registerEmail: String, registerPassword: String) {
        if (registerEmail.isNotEmpty() && registerPassword.isNotEmpty()) {
            viewModelScope.launch {
                val result = userRepository.registerUser(registerEmail, registerPassword)
                _authStatus.value = result
                if (result == "Register Successful") {
                    _navigateTo.value = HomeScreenActivity::class.java
                }
            }
        } else {
            _authStatus.value = "Email and Password cannot be empty"
        }
    }
    fun onRegisterSimpleClicked() {
        _navigateTo.value = RegisterActivity::class.java
    }

    fun onForgotPasswordClicked() {
        _navigateTo.value = ForgotPasswordActivity::class.java
    }

    fun doneNavigating() {
        _navigateTo.value = null
    }

    fun logout() {
        userRepository.logoutUser()
    }

    fun isUserLoggedIn(): Boolean {
        return userRepository.isUserLoggedIn()
    }
}