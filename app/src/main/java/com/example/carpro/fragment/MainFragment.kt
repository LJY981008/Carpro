package com.example.carpro.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.carpro.R
import com.example.carpro.databinding.FragmentMainBinding
import com.example.carpro.databinding.FragmentSaleBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.sale.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_global_saleFragment)
        }
        binding.sell.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_global_sellFragment)
        }
        binding.price.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_global_priceFragment)
        }
        binding.accident.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_global_accidentFragment)
        }
        binding.alliance.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_global_allianceFragment)
        }
        binding.repair.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_global_repairFragment)
        }







        return binding.root
    }

}