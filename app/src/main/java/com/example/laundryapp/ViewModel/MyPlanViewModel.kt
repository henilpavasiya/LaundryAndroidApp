package com.example.laundryapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laundryapp.Repository.PlanRepository
import com.example.laundryapp.View.Home.Profile.PlanPaymentActivity
import kotlinx.coroutines.launch

class MyPlanViewModel(private val planRepository: PlanRepository) : ViewModel() {
    private val _planLastDate = MutableLiveData<String>()
    val planLastDate: LiveData<String> = _planLastDate

    private val _planPrice = MutableLiveData<Int>()
    val planPrice: LiveData<Int> = _planPrice

    private val _planStatus = MutableLiveData<Boolean>()
    val planStatus: LiveData<Boolean> = _planStatus

    private val _planTitle = MutableLiveData<String>()
    val planTitle: LiveData<String> = _planTitle

    private val _navigateTo = MutableLiveData<Class<*>?>()
    val navigateTo : LiveData<Class<*>?> get() = _navigateTo

    private val _authStatus = MutableLiveData<String>()
    val authStatus: LiveData<String> get() = _authStatus

    fun buyLaundryPlan(lastDate: String, price: Int, status: Boolean, title: String) {
        viewModelScope.launch {
            val updateResult = planRepository.orderLaundryPlan(lastDate, price, status, title)
            if(updateResult == "Laundry plan has been changed successfully"){
                _navigateTo.value = PlanPaymentActivity::class.java
            }
            else{
                _authStatus.value = updateResult ?: "Failed to update user data"
            }
        }
    }
}