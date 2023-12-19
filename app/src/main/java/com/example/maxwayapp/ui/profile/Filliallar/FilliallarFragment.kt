package com.example.maxwayapp.ui.profile.Filliallar

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maxwayapp.R
import com.example.maxwayapp.adapter.FilliallarAdapter
import com.example.maxwayapp.databinding.FragmentFilliallarBinding
import com.example.maxwayapp.extention.requarebuttonNav
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilliallarFragment :Fragment(R.layout.fragment_filliallar) {

    private val binding:FragmentFilliallarBinding by viewBinding()
    private lateinit var adapter: FilliallarAdapter
    private lateinit var list: ArrayList<String>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list=ArrayList()
        for(i in 0..10 ){
            list .add("Apple")
        }

        requarebuttonNav(this)

        adapter= FilliallarAdapter(list) { it, _ ->
            findNavController().navigate(R.id.action_filliallarFragment_to_fillialFragment)
        }

        binding.rv.adapter=adapter
    }


}