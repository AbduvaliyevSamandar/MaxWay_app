package com.example.maxwayapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maxwayapp.R
import com.example.maxwayapp.databinding.FoodItemBinding
import com.example.maxwayapp.domain.entity.Category
import com.example.maxwayapp.domain.entity.ProductX
import com.squareup.picasso.Picasso

class ViewPagerAdapter(
    var list: List<ProductX>,
    val onItemClick:(ProductX, Int)->Unit
): RecyclerView.Adapter<ViewPagerAdapter.VH>() {

    inner class VH(var itemFilliallarBinding: FoodItemBinding) :
        RecyclerView.ViewHolder(itemFilliallarBinding.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(data: List<ProductX>, position: Int) {
            itemFilliallarBinding.apply {
                name.text = data[position].title.uz
                description.text = data[position].description.uz
                cost.text = formatMoney(data[position].out_price.toLong())
                Picasso.get().load("https://cdn.delever.uz/delever/" + data[position].image)
                    .placeholder(R.drawable.img_14)
                    .error(R.drawable.img_15)
                    .into(image)
                itemView.setOnClickListener { onItemClick.invoke(data[position], position) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(FoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list, position)
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