package com.example.maxwayapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maxwayapp.R
import com.example.maxwayapp.database.Database
import com.example.maxwayapp.databinding.ItemCartBinding
import com.example.maxwayapp.databinding.ItemFilliallarBinding
import com.example.maxwayapp.domain.entitydatabase.Cart
import com.example.maxwayapp.extention.formatMoney
import com.squareup.picasso.Picasso

class CartAdapter (
    var list:List<Cart>,
    val onItemClick:(Cart,Int)->Unit,
    val context: Context
): RecyclerView.Adapter<CartAdapter.VH>()  {

    inner class VH(var itemFilliallarBinding: ItemCartBinding):RecyclerView.ViewHolder(itemFilliallarBinding.root){
        private val database by lazy { Database.getDatabase(context) }


        @SuppressLint("SetTextI18n")
        fun onBind(data:Cart, position:Int){
            itemFilliallarBinding.apply {
                textView13.text=data.titlecart
                count.text=data.count
                Picasso.get().load("https://cdn.delever.uz/delever/" + data.imagecart)
                    .placeholder(R.drawable.img_14)
                    .error(R.drawable.img_15)
                    .into(image)
                amount.text=data.amount

                pluscart.setOnClickListener {
                    count.text= " "+(count.text.toString().trim().toInt()+1).toString()+" "
                    val cart=Cart(imagecart = data.imagecart, titlecart = data.titlecart, desc = data.desc, count = count.text.toString(), amount = data.amount)
                    database.cartDao().updatecard(cart)
                }
                minus.setOnClickListener {
                    if (count.text.toString().trim().toInt()>1){
                        count.text= " "+(count.text.toString().trim().toInt()-1).toString()+" "
                        val cart=Cart(imagecart = data.imagecart, titlecart = data.titlecart, desc = data.desc, count = count.text.toString(), amount = data.amount)
                        database.cartDao().updatecard(cart)
                    }
                }
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