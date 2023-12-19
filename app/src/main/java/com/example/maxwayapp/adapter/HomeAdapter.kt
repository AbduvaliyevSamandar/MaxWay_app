package com.example.maxwayapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maxwayapp.databinding.FragmentViewpagerBinding
import com.example.maxwayapp.domain.entity.Category
import com.example.maxwayapp.domain.entity.ProductX

class HomeAdapter (
    var list:List<Category>,
    var namelist:List<Category>,
    val onItemClick:(ProductX, Int)->Unit
): RecyclerView.Adapter<HomeAdapter.VH>()  {

    private var currentTabPosition = 0

    fun SetList(data:List<Category>,namedata:List<Category>){
        list=data
        namelist=namedata
        notifyDataSetChanged()
    }
    fun setCurrentTabPosition(position: Int) {
        currentTabPosition = position
    }

    inner class VH(var itemFilliallarBinding: FragmentViewpagerBinding):RecyclerView.ViewHolder(itemFilliallarBinding.root){

        @SuppressLint("SetTextI18n")
        fun onBind(data: List<Category>, position:Int, list:List<Category>){
            itemFilliallarBinding.apply {

                rvViewPager.adapter=ViewPagerAdapter(list[position].products,onItemClick)
                pagettext.text=data[position].title.uz
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            FragmentViewpagerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun getItemCount()=namelist.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(namelist,position,list)
    }




}