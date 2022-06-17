package com.example.carpro.saleList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.carpro.R
import com.example.carpro.databinding.ItemSalecarBinding

class SaleAdapter(private val items: MutableList<SaleInfo>) :
    RecyclerView.Adapter<SaleAdapter.ViewHolder>() {

    interface ItemClickListener {
        fun onClickItem(position: Int)
    }

    var itemClickListener: ItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaleAdapter.ViewHolder {
        val binding = ItemSalecarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SaleAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.apply {
            bind(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }



    class ViewHolder(private val binding: ItemSalecarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SaleInfo) {
            binding.tvCarType.text = "차종 : " + item.carType
            binding.tvCarPrice.text = "가격 : " + item.carPrice + " 만원"

            binding.LinearSalecar.setOnClickListener {
                val dialogView =
                    LayoutInflater.from(itemView.context).inflate(R.layout.dialog_sale, null)
                val builder =
                    AlertDialog.Builder(itemView.context).setView(dialogView).setTitle("상세정보")

                dialogView.findViewById<TextView>(R.id.dtv_carType).text = "차종 : " + item.carType
                dialogView.findViewById<TextView>(R.id.dtv_carPrice).text = "가격 : " + item.carPrice + " 만원"
                dialogView.findViewById<TextView>(R.id.dtv_carIntroduce).text = "설명\n" + item.carIntroduce
                var i = item.carUri.size
                if (i > 0) dialogView.findViewById<ImageView>(R.id.image1)
                    .setImageURI(item.carUri[0])
                if (i > 1) dialogView.findViewById<ImageView>(R.id.image2)
                    .setImageURI(item.carUri[1])
                if (i > 2) dialogView.findViewById<ImageView>(R.id.image3)
                    .setImageURI(item.carUri[2])
                if (i > 3) dialogView.findViewById<ImageView>(R.id.image4)
                    .setImageURI(item.carUri[3])
                if (i > 4) dialogView.findViewById<ImageView>(R.id.image5)
                    .setImageURI(item.carUri[4])

                val alert = builder.create()
                alert.show()
                alert.window?.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
                dialogView.findViewById<Button>(R.id.btn_OK).setOnClickListener {
                    alert.dismiss()
                }
            }
        }
    }
}