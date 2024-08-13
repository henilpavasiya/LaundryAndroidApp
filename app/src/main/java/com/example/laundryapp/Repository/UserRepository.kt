package com.example.laundryapp.Repository

import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.tasks.await

class UserRepository {
    private val auth = FirebaseAuth.getInstance()

    suspend fun registerUser(email: String, password: String): String {
        return try {
            auth.createUserWithEmailAndPassword(email, password).await()
            "Register Successful"
        } catch (e: Exception) {
            e.message ?: "Register Failed"
        }
    }

    suspend fun loginUser(email: String, password: String): String {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            "Login Successful"
        } catch (e: Exception) {
            e.message ?: "Login Failed"
        }
    }

    suspend fun updateUser(username: String, userImage: Uri): Void? {
        return auth.currentUser?.let {
            val profileUpdate = UserProfileChangeRequest.Builder()
                .setDisplayName(username)
                .setPhotoUri(userImage)
                .build()
            it.updateProfile(profileUpdate).await()
        }
    }

    fun logoutUser() {
        auth.signOut()
    }

    fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }


}