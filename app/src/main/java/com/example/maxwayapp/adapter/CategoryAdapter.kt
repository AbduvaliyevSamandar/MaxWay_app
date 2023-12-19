package com.example.maxwayapp.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maxwayapp.R
import com.example.maxwayapp.databinding.ItemCategoriesBinding
import com.example.maxwayapp.domain.entity.Category

class CategoryAdapter (
    var list:List<Category>,
    val onItemClick:(Category,Int)->Unit
): RecyclerView.Adapter<CategoryAdapter.VH>()  {

    fun SetList(data:List<Category>){
        list=data
        notifyDataSetChanged()
    }

    var currentPosition = 0
    inner class VH(var itemFilliallarBinding: ItemCategoriesBinding):RecyclerView.ViewHolder(itemFilliallarBinding.root){

        @SuppressLint("SetTextI18n", "ResourceAsColor")
        fun onBind(data: Category, position:Int){
            itemFilliallarBinding.apply {

                textView28.text=data.title.uz
                itemView.setOnClickListener {
                    onItemClick.invoke(data,position)
                    notifyItemChanged(currentPosition)
                    currentPosition = adapterPosition
                    notifyItemChanged(currentPosition)

                }
                    if(adapterPosition == currentPosition) {
                        frem.setBackgroundResource( R.drawable.backrount2)
                        textView28.setTextColor(Color.WHITE)
                    }
                    else {
                        frem.setBackgroundResource(R.drawable.backrount3)
                        textView28.setTextColor(Color.BLACK)
                    }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position],position)
    }

}