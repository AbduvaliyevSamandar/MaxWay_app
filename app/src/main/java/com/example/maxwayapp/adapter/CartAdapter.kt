package com.example.maxwayapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maxwayapp.databinding.ItemCartBinding
import com.example.maxwayapp.databinding.ItemFilliallarBinding

class CartAdapter (
    var list:List<String>,
    val onItemClick:(String,Int)->Unit
): RecyclerView.Adapter<CartAdapter.VH>()  {

    inner class VH(var itemFilliallarBinding: ItemCartBinding):RecyclerView.ViewHolder(itemFilliallarBinding.root){

        @SuppressLint("SetTextI18n")
        fun onBind(data:String, position:Int){
            itemFilliallarBinding.apply {

                textView13.text=data
                itemView.setOnClickListener { onItemClick.invoke(data,position)}
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemCartBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position],position)
    }
}