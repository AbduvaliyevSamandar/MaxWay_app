package com.example.maxwayapp.ui.cart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maxwayapp.R
import com.example.maxwayapp.adapter.CartAdapter
import com.example.maxwayapp.adapter.FilliallarAdapter
import com.example.maxwayapp.databinding.FragmentCartBinding

class CartFragment : Fragment(R.layout.fragment_cart) {

    private val binding: FragmentCartBinding by viewBinding()
    private lateinit var adapter: CartAdapter
    private lateinit var list: ArrayList<String>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list=ArrayList()
        for(i in 0..20 ){
            list .add("Klap sendvich")
        }
        adapter= CartAdapter(list) { it, _ ->

        }

        binding.rvcart.adapter=adapter
    }


}