package com.example.laundryapp.Repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class PlanRepository {

    private val auth = FirebaseAuth.getInstance()
    private val firestore=FirebaseFirestore.getInstance()

    suspend fun orderLaundryPlan(planLastDate:String, planPrice:Int, planStatus:Boolean,planTitle:String):String?{
        return auth.currentUser?.let { user->
            try{
                val planMap = hashMapOf(
                    "planLastDate" to planLastDate,
                    "planPrice" to planPrice,
                    "planStatus" to planStatus,
                    "planTitle" to planTitle
                )
                firestore.collection("users").document(user.uid).update(planMap as Map<String, Any>).await()
                "Laundry plan has been changed successfully"
            }
            catch (e:Exception){
                e.message ?: "Failed to change laundry plan"
            }

        }
    }
}