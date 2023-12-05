package com.example.maxwayapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maxwayapp.R
import com.example.maxwayapp.adapter.PagerAdapter
import com.example.maxwayapp.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment(R.layout.fragment_home) {

    private  val ARG_OBJECT = "object"
    private val binding:FragmentHomeBinding by viewBinding()
    private var data=ArrayList<String>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        data= ArrayList()
        for (i in 0..10){
            data.add("Maxi Boxddddd")
        }

        binding.pager.adapter= PagerAdapter(this,data)
        binding.pager.offscreenPageLimit=5

       binding.pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
            }
        })
        TabLayoutMediator(binding.tab, binding.pager) { tab, position ->
            tab.text=position.toString()
        }.attach()
    }


}


