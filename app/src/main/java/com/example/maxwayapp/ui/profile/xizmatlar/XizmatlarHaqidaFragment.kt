package com.example.maxwayapp.ui.profile.xizmatlar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maxwayapp.R
import com.example.maxwayapp.databinding.FragmentXizmatlarBinding
import com.example.maxwayapp.extention.requarebuttonNav
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class XizmatlarHaqidaFragment :Fragment(R.layout.fragment_xizmatlar) {
    private val binding:FragmentXizmatlarBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requarebuttonNav(this)
        binding.bizHaqimizda.setOnClickListener {
            findNavController().navigate(R.id.action_xizmatlarHaqidaFragment_to_bizHaqimizdaFragment)
        }
        binding.ommaviyOferta.setOnClickListener {
            findNavController().navigate(R.id.action_xizmatlarHaqidaFragment_to_bizHaqimizdaFragment)
        }
    }
}