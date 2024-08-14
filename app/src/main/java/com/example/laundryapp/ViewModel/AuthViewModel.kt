package com.example.laundryapp.ViewModel

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laundryapp.Repository.UserRepository
import com.example.laundryapp.View.Auth.ForgotPasswordActivity
import com.example.laundryapp.View.Auth.LoginActivity
import com.example.laundryapp.View.Auth.RegisterActivity
import com.example.laundryapp.View.Home.HomeScreenActivity
import kotlinx.coroutines.launch

class AuthViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _navigateTo = MutableLiveData<Class<*>?>()
    val navigateTo: LiveData<Class<*>?> get() = _navigateTo

    private val _authStatus = MutableLiveData<String>()
    val authStatus: LiveData<String> get() = _authStatus

    private val _showLogoutDialog = MutableLiveData<Boolean>()
    val showLogoutDialog: LiveData<Boolean> = _showLogoutDialog

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> get() = _userName

    private val _userEmail = MutableLiveData<String>()
    val userEmail:LiveData<String> get() = _userEmail

    private val _userImageUri = MutableLiveData<Uri>()
    val userImageUri:LiveData<Uri> = _userImageUri

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

    fun onRegisterClicked(
        registerImageView: Uri,
        registerName: String,
        registerEmail: String,
        registerPassword: String
    ) {
        if (registerEmail.isNotEmpty() && registerPassword.isNotEmpty()) {
            viewModelScope.launch {
                val result = userRepository.registerUser(registerEmail, registerPassword)
                if (result == "Register Successful") {
                    val updateResult = userRepository.updateUser(username = registerName, userImage = registerImageView)
                    Log.d("UserData", "User data update result: -> $updateResult")
                    if (updateResult == "User Profile Updated Successfully") {
                        _userImageUri.value = registerImageView
                        _navigateTo.value = HomeScreenActivity::class.java
                    }
                    else{
                        _authStatus.value = updateResult ?: "Failed to update user data"
                    }
                } else {
                    _authStatus.value = result
                }
            }
        } else {
            _authStatus.value = "Email and Password cannot be empty"
        }
    }

    fun loadUserData() {
        viewModelScope.launch {
            val currentUser = userRepository.getCurrentUser()
            if (currentUser != null) {
                _userEmail.value = currentUser.email

                // Get additional user data from Firestore
                val userData = userRepository.getUserData(currentUser.uid)
                userData?.let {
                    _userName.value = it["username"] as String
                    _userImageUri.value = Uri.parse(it["profileImage"] as String)
                }
            }
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
        _navigateTo.value = LoginActivity::class.java
    }

    fun isUserLoggedIn(): Boolean {
        return userRepository.isUserLoggedIn()
    }

    fun requestLogoutDialog() {
        _showLogoutDialog.value = true
    }

    fun logoutDialogShown() {
        _showLogoutDialog.value = false
    }
}