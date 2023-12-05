package com.example.maxwayapp.ui.home.HomeViewPager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maxwayapp.R
import com.example.maxwayapp.adapter.FilliallarAdapter
import com.example.maxwayapp.adapter.ViewPagerAdapter
import com.example.maxwayapp.databinding.FragmentViewpagerBinding

class ViewPagerFragment :Fragment(R.layout.fragment_viewpager) {
    private val binding:FragmentViewpagerBinding by viewBinding()
    private lateinit var adapter: ViewPagerAdapter
    private lateinit var list: ArrayList<String>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list=ArrayList()
        for(i in 0..4 ){
            list .add("Maxi Box")
        }
        adapter= ViewPagerAdapter(list) { it, _ ->

        }

        binding.pagettext.text=arguments?.getString("text")
        binding.rvViewPager.adapter=adapter
    }


}