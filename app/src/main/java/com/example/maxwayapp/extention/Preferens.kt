package com.example.maxwayapp.extention

import android.content.Context
import android.content.SharedPreferences

class Preferens (context: Context){

    private  var preferences: SharedPreferences =context.getSharedPreferences("settings",
        Context.MODE_PRIVATE)
    companion object{
        lateinit var  settings:Preferens
        fun getSettings(context: Context):Preferens{
            if (!::settings.isInitialized){
                settings=Preferens(context)
            }
            return settings
        }

    }

    fun setProductId(pincode:String){
        preferences.edit().putString("pin",pincode).apply()
    }
    fun getProductId():String?{
        return preferences.getString("pin","")
    }
}