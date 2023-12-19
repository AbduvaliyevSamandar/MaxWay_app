package com.example.maxwayapp.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maxwayapp.R
import com.example.maxwayapp.adapter.CategoryAdapter
import com.example.maxwayapp.adapter.HomeAdapter
import com.example.maxwayapp.databinding.FragmentHomeBinding
import com.example.maxwayapp.domain.entity.Category
import com.example.maxwayapp.extention.Preferens
import com.example.maxwayapp.extention.requarebuttonNavVisibl
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel:HomeViewModel by viewModels()
    private  val ARG_OBJECT = "object"
    private val binding:FragmentHomeBinding by viewBinding()
    private var namelist=ArrayList<Category>()
    private var list=ArrayList<Category>()

    private lateinit var prefens:Preferens


    private var listcategory=ArrayList<Category>()
    private lateinit var adapterpager:HomeAdapter
    private lateinit var adaptertab: CategoryAdapter

    override fun onStart() {
        requarebuttonNavVisibl(this)
        super.onStart()
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.location.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_mapFragment)
        }

        prefens=Preferens.getSettings(requireContext())

         homeViewModel.getCategoryWhithProduct()

        adapterpager=HomeAdapter(list,namelist) { lis, index ->
            prefens.setProductId(lis.id)
            findNavController().navigate(R.id.action_navigation_home_to_addKarzinka)
        }
        binding.pager.adapter= adapterpager

        namelist= ArrayList()
        list= ArrayList()

        adaptertab=CategoryAdapter(listcategory) { _, index ->
            binding.pager.itemAnimator = DefaultItemAnimator()
            val layoutManager = binding.pager.layoutManager as LinearLayoutManager
                    layoutManager.scrollToPositionWithOffset(index, 0)
        }
        binding.tab.adapter=adaptertab
        binding.pager.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = binding.pager.layoutManager as LinearLayoutManager
                val visibleChildCount = layoutManager.childCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                val centerItemPosition = firstVisibleItemPosition + visibleChildCount / 2
                val layoutManagertab = binding.tab.layoutManager as LinearLayoutManager
                        adaptertab.currentPosition=centerItemPosition
                        layoutManagertab.scrollToPositionWithOffset(centerItemPosition, 0)
            }
        })
//      binding.search.addTextChangedListener{
//          val query = it?.toString()
//          val data = ArrayList<Category>()
//          Toast.makeText(requireContext(), "${data.size}", Toast.LENGTH_SHORT).show()
//
//      }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED){
                homeViewModel.openSuccesFlow.collect{
                    Log.d("sss", "${it.categories}")
                    adapterpager.SetList(it.categories,it.categories)
                    adaptertab.SetList(it.categories)




                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED){
                homeViewModel.errorFlow.collect{
                    Log.d("sss", "$it")
                    Toast.makeText(requireContext(), "${it}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED){
                homeViewModel.noNetworkFlow.collect{
                    Log.d("sss", "Internet yoq")
                    Toast.makeText(requireContext(), "Internet yoq", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}




