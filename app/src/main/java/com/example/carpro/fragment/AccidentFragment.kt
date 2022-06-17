package com.example.carpro.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.carpro.R
import com.example.carpro.databinding.FragmentAccidentBinding

class AccidentFragment : Fragment() {
    private lateinit var binding: FragmentAccidentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccidentBinding.inflate(inflater, container, false)

        binding.btnSearch.setOnClickListener {
            if (binding.editCarNumber.text.isNullOrBlank()) {
                Toast.makeText(context, "차량번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                binding.tvResult.text = "${binding.editCarNumber.text}" + "의 사고이력"
            }

        }


        return binding.root
    }
}