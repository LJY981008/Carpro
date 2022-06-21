package com.example.carpro.topTap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carpro.R
import com.example.carpro.databinding.FragmentFirstTopBinding

class FirstTopFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFirstTopBinding.inflate(inflater, container, false)
        binding.back.setBackgroundResource(R.drawable.logo1)

        return binding.root
    }

}