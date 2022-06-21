package com.example.carpro.topTap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carpro.R
import com.example.carpro.databinding.FragmentFirstTopBinding
import com.example.carpro.databinding.FragmentThirdTopBinding

class ThirdTopFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentThirdTopBinding.inflate(inflater, container, false)
        binding.back.setBackgroundResource(R.drawable.logo3)

        return binding.root
    }
}