package com.example.carpro.fragment

import android.content.DialogInterface
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.carpro.R
import com.example.carpro.Util
import com.example.carpro.databinding.FragmentSaleBinding
import com.example.carpro.saleList.SaleAdapter

class SaleFragment : Fragment() {
    private lateinit var binding: FragmentSaleBinding
    private lateinit var adapter: SaleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSaleBinding.inflate(inflater, container, false)
        adapter = SaleAdapter(Util.carInfo)

        binding.viewCarlist.adapter = adapter
        adapter.notifyDataSetChanged()

        return binding.root
    }


}