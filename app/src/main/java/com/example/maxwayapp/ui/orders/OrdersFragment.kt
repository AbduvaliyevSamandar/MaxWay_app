package com.example.maxwayapp.ui.orders

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maxwayapp.R
import com.example.maxwayapp.databinding.FragmentOrdersBinding
import com.example.maxwayapp.extention.requarebuttonNavVisibl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrdersFragment : Fragment(R.layout.fragment_orders) {

    private val binding:FragmentOrdersBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requarebuttonNavVisibl(this)
    }
}