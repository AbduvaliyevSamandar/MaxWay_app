package com.example.maxwayapp.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maxwayapp.R
import com.example.maxwayapp.databinding.FragmentProfileBinding

class ProfileFragment :Fragment(R.layout.fragment_profile) {

    private val binding:FragmentProfileBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageView.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_profile_to_profileEditFragment)
        }
        binding.constraintLayout2.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_profile_to_filliallarFragment)
        }
        binding.Settings.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_profile_to_sozlamalarFragment)
        }
        binding.malumotlar.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_profile_to_xizmatlarHaqidaFragment)
        }
    }


}