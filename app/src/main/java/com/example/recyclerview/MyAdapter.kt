package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemActivityBinding

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    val carList = ArrayList<MainClass>()

    class MyViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemActivityBinding.bind((item))
        fun bind (mainClass: MainClass){
            binding.imageView.setImageResource(mainClass.imageId)
            binding.textView.text = mainClass.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(carList[position])
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    fun addCar (mainClass: MainClass){
        carList.add(mainClass)
        notifyDataSetChanged()
    }
}

