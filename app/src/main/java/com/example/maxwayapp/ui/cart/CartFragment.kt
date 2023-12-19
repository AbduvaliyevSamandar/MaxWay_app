package com.example.maxwayapp.ui.cart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maxwayapp.R
import com.example.maxwayapp.adapter.CartAdapter
import com.example.maxwayapp.database.Database
import com.example.maxwayapp.databinding.FragmentCartBinding
import com.example.maxwayapp.extention.requarebuttonNavVisibl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment(R.layout.fragment_cart) {

    private val binding: FragmentCartBinding by viewBinding()
    private lateinit var adapter: CartAdapter
    private lateinit var list: ArrayList<String>

    private val database by lazy { Database.getDatabase(requireContext()) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requarebuttonNavVisibl(this)
        list=ArrayList()
        for(i in 0..20 ){
            list .add("Klap sendvich")
        }
        adapter= CartAdapter(list = database.cartDao().getCards(), context = requireContext(),
            onItemClick = { it, _ ->

            })

        binding.rvcart.adapter=adapter
    }


}