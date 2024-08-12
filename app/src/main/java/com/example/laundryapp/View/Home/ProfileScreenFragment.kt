package com.example.laundryapp.View.Home

import ViewModelFactory
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.laundryapp.R
import com.example.laundryapp.Repository.UserRepository
import com.example.laundryapp.ViewModel.AuthViewModel
import com.example.laundryapp.databinding.FragmentProfileScreenBinding

class ProfileScreenFragment : Fragment(R.layout.fragment_profile_screen) {
    private lateinit var binding: FragmentProfileScreenBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileScreenBinding.bind(view)

        val userRepository = UserRepository()
        authViewModel =
            ViewModelProvider(this, ViewModelFactory(userRepository))[AuthViewModel::class.java]

        binding.apply {
            buttonLogout.setOnClickListener {
                authViewModel.requestLogoutDialog()
            }
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        authViewModel.showLogoutDialog.observe(viewLifecycleOwner) { show ->
            if (show) {
                showLogoutDialog()
            }
        }
        authViewModel.navigateTo.observe(viewLifecycleOwner, Observer { destination ->
            destination?.let {
                Intent(requireActivity(), it).also { intent ->
                    startActivity(intent)
                    authViewModel.doneNavigating()
                    requireActivity().finish() // If you want to close the activity after navigation
                }
            }
        })
    }

    private fun showLogoutDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setIcon(R.drawable.power)
            .setPositiveButton("Yes") { _, _ ->
                Log.d("Logout", "User confirmed logout")
                authViewModel.logout()
                authViewModel.logoutDialogShown()
            }
            .setNegativeButton("No") { dialog, _ ->
                Log.d("Logout", "User cancelled logout")
                dialog.dismiss()
                authViewModel.logoutDialogShown()
            }
            .create()
            .show()
    }

    init {
        Log.d("Fragment", "ProfileScreen Fragment")
    }
}
