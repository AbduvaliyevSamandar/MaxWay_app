package com.example.maxwayapp.extention

import android.view.View
import androidx.fragment.app.Fragment
import com.example.maxwayapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

fun requarebuttonNav(fr:Fragment){
    fr.apply {
        requireActivity().findViewById<BottomNavigationView>(R.id.nav_view).visibility= View.INVISIBLE
    }

}
fun requarebuttonNavVisibl(fr:Fragment){
    fr.apply {
        requireActivity().findViewById<BottomNavigationView>(R.id.nav_view).visibility= View.VISIBLE
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