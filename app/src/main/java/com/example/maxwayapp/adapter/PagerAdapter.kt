package com.example.maxwayapp.adapter

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.maxwayapp.ui.home.HomeViewPager.ViewPagerFragment

class PagerAdapter( fragment:Fragment, val data:ArrayList<String>):FragmentStateAdapter(fragment) {

    override fun getItemCount()=data.size

    override fun createFragment(position: Int): Fragment {
        return ViewPagerFragment().apply {
            arguments= bundleOf("text" to data[position])
        }

    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }
}