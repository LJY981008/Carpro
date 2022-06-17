package com.example.carpro.allianceList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carpro.databinding.ActivityMainBinding.bind
import com.example.carpro.databinding.ItemAllianceBinding
import com.example.carpro.saleList.SaleAdapter

class AllianceAdapter(private val items: MutableList<AllianceInfo>) :
    RecyclerView.Adapter<AllianceAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllianceAdapter.ViewHolder {
        val binding =
            ItemAllianceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AllianceAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.apply {
            bind(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(private val binding: ItemAllianceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AllianceInfo) {
            binding.imgUserIcon.setImageDrawable(item.img)
            binding.tvAllianceName.text = item.name
            binding.tvAlliancePhone.text = item.phone
        }

    }
}