package com.example.maxwayapp.ui.profile.Fillial

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maxwayapp.R
import com.example.maxwayapp.databinding.FragmentFillialBinding
import com.example.maxwayapp.extention.requarebuttonNav
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FillialFragment :Fragment(R.layout.fragment_fillial) {
    private val binding:FragmentFillialBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requarebuttonNav(this)
    }
}