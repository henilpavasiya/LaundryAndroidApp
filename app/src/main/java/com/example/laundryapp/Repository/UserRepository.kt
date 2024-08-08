package com.example.laundryapp.Repository

import com.google.firebase.auth.FirebaseAuth
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

    fun logoutUser(){
        auth.signOut()
    }

    fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }


}