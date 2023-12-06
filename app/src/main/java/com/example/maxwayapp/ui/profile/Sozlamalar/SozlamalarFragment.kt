package com.example.maxwayapp.ui.profile.Sozlamalar

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maxwayapp.databinding.BottonsheetlayoutBinding
import com.example.maxwayapp.databinding.FragmentSozlamalarBinding
import com.github.angads25.toggle.interfaces.OnToggledListener
import com.github.angads25.toggle.model.ToggleableView


class SozlamalarFragment :Fragment(com.example.maxwayapp.R.layout.fragment_sozlamalar) {

    private val binding:FragmentSozlamalarBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.labeledSwitch.setOnToggledListener(object : OnToggledListener {

            override fun onSwitched(toggleableView: ToggleableView?, isOn: Boolean) {

            }
        })
        binding.bottomsheet.setOnClickListener {
            showDialog()
        }
    }

    private val bindingbottom:BottonsheetlayoutBinding by viewBinding()

    private fun showDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(com.example.maxwayapp.R.layout.bottonsheetlayout)


        val rustili = dialog.findViewById<LinearLayout>(com.example.maxwayapp.R.id.rus_tili)
        val uztili = dialog.findViewById<LinearLayout>(com.example.maxwayapp.R.id.uz_tili)
        val ingtili = dialog.findViewById<LinearLayout>(com.example.maxwayapp.R.id.ing_tili)

        val ruscheak = dialog.findViewById<ImageView>(com.example.maxwayapp.R.id.ruscheak)
        val uzcheak = dialog.findViewById<ImageView>(com.example.maxwayapp.R.id.uzcheak)
        val ingcheak = dialog.findViewById<ImageView>(com.example.maxwayapp.R.id.incheak)

        rustili.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(requireContext(), "Rus tili", Toast.LENGTH_SHORT).show()
            ruscheak.visibility=View.VISIBLE
        }
        uztili.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(requireContext(), "O'zbek tili", Toast.LENGTH_SHORT).show()
            uzcheak.visibility=View.VISIBLE
        }
        ingtili.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(requireContext(), "Ingliz tili", Toast.LENGTH_SHORT).show()
            ingcheak.visibility=View.VISIBLE
        }

        dialog.show()
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = com.example.maxwayapp.R.style.DialogAnimation
        dialog.window!!.setGravity(Gravity.BOTTOM)
    }
}