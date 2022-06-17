package com.example.carpro.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.carpro.R
import com.example.carpro.databinding.FragmentSellBinding

class SellFragment : Fragment() {

    private lateinit var binding: FragmentSellBinding
    private lateinit var spinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSellBinding.inflate(inflater, container, false)

        spinner = binding.typeCar

        spinner.adapter = ArrayAdapter.createFromResource(container!!.context, R.array.carList, android.R.layout.simple_spinner_item)




        return binding.root
    }

}