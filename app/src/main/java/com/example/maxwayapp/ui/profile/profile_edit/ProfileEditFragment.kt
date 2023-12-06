package com.example.maxwayapp.ui.profile.profile_edit

import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maxwayapp.R
import com.example.maxwayapp.databinding.FragmentEditProfileBinding
import java.util.Calendar

class ProfileEditFragment :Fragment(R.layout.fragment_edit_profile) {

    private val binding:FragmentEditProfileBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.datePicker1


        val today = Calendar.getInstance()
        binding.datePicker1.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val month = month + 1
            val msg = "$day.$month.$year"
            binding.editTextDate.text=msg
        }
    }
}