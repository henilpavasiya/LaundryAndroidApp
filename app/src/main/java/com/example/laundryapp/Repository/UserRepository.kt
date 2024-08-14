package com.example.laundryapp.Repository

import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UserRepository {
    private val auth = FirebaseAuth.getInstance()
    private val firestore= FirebaseFirestore.getInstance()

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

    suspend fun updateUser(username: String, userImage: Uri): String? {
        return auth.currentUser?.let {user->
            try {
                // Update user profile in Firebase Auth
                val profileUpdate = UserProfileChangeRequest.Builder()
                    .setDisplayName(username)
                    .setPhotoUri(userImage)
                    .build()
                user.updateProfile(profileUpdate).await()

                // Save additional user data in Firestore
                val userMap = hashMapOf(
                    "uid" to user.uid,
                    "username" to username,
                    "email" to user.email,
                    "profileImage" to userImage.toString()
                )
                firestore.collection("users").document(user.uid).set(userMap).await()
                "User Profile Updated Successfully"
            } catch (e: Exception) {
                e.message ?: "Failed to update user profile"
            }
        }
    }

    fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }

    suspend fun getUserData(uid: String): Map<String, Any>? {
        return try {
            firestore.collection("users").document(uid).get().await().data
        } catch (e: Exception) {
            null
        }
    }


    fun logoutUser() {
        auth.signOut()
    }

    fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }


}