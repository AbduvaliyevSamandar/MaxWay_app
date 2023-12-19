package com.example.maxwayapp.ui.addKarzinka

import android.annotation.SuppressLint
import android.graphics.Color
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
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maxwayapp.R
import com.example.maxwayapp.database.Database
import com.example.maxwayapp.databinding.FragmentAddkorzinkaBinding
import com.example.maxwayapp.domain.entitydatabase.Cart
import com.example.maxwayapp.extention.Preferens
import com.example.maxwayapp.extention.requarebuttonNav
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddKarzinka : Fragment(R.layout.fragment_addkorzinka) {

    private val binding:FragmentAddkorzinkaBinding by viewBinding()

    private val viewModel:AddKarzinkaViewModel by viewModels()

    private lateinit var preferens:Preferens
    private lateinit var amount:String

    private lateinit var image:String

    private val database by lazy { Database.getDatabase(requireContext()) }
    private var qosh=false
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requarebuttonNav(this)
        preferens=Preferens.getSettings(requireContext())




        viewModel.productDetail(preferens.getProductId().toString())



        binding.plus.setOnClickListener {
            binding.count.text= " "+(binding.count.text.toString().trim().toInt()+1).toString()+" "
            binding.Cost.text= formatMoney((binding.Cost.text.toString().replace(" ","").trim().toInt()+amount.replace(" ","").trim().toInt()).toLong())
        }

        binding.minus.setOnClickListener {
            if (binding.count.text.toString().trim().toInt()>1){
                binding.count.text= " "+(binding.count.text.toString().trim().toInt()-1).toString()+" "
                binding.Cost.text= formatMoney((binding.Cost.text.toString().replace(" ","").trim().toInt()-amount.replace(" ","").trim().toInt()).toLong())
            }
        }



        binding.addCart.setOnClickListener {
            if (qosh){
                findNavController().navigate(R.id.action_addKarzinka_to_navigation_cart)
            }
            else{
                binding.qoshish.text="Savatga"
                qosh=true
                val snackbar= Snackbar.make(it,"Karzinkaga qoshildi",Snackbar.LENGTH_LONG).setAction("Action",null)
                snackbar.setActionTextColor(Color.WHITE)
                val snackBarView=snackbar.view
                snackBarView.setBackgroundColor(Color.BLUE)
                snackbar.show()
                val cart=Cart(imagecart = image, titlecart = binding.categorytypr.text.toString(), desc = binding.descitem.text.toString(), count = binding.count.text.toString(), amount = amount)
                database.cartDao().insert(cart)
            }


        }


        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED){
                viewModel.openSuccesFlow.collect{

                    amount=it.out_price.toString()
                    binding.Cost.text=it.out_price.toString()
                    amount=amount.replace(" ","");

                    Picasso.get().load("https://cdn.delever.uz/delever/"+it.image)
                        .placeholder(R.drawable.img_14)
                        .error(R.drawable.img_15)
                        .into(binding.cardview)
                    image=it.image

                    binding.categorytypr.text=it.title.uz
                    binding.descitem.text=it.description.uz
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED){
                viewModel.errorFlow.collect{
                    Log.d("sss", "$it")
                    Toast.makeText(requireContext(), "${it}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED){
                viewModel.noNetworkFlow.collect{
                    Log.d("sss", "Internet yoq")
                    Toast.makeText(requireContext(), "Internet yoq", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun formatMoney(amount: Long): String {
        val number = amount.toString()
        val builder = StringBuilder()

        for(i in number.length - 1 downTo 0 step 1) {
            builder.append(number[i])
            if((number.length - i) % 3 == 0 && i != number.length - 1) {
                builder.append(" ")
            }
        }

        return builder.reverse().toString()
    }
}