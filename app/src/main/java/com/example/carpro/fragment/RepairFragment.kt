package com.example.carpro.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.carpro.R
import com.example.carpro.databinding.FragmentRepairBinding

class RepairFragment : Fragment() {
    private lateinit var binding: FragmentRepairBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRepairBinding.inflate(inflater, container, false)

        binding.btnSearch.setOnClickListener {
            if(binding.editCarNumber.text.isNullOrBlank()) {
                Toast.makeText(context, "차량번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }else{
                binding.tvResult.text = "${binding.editCarNumber.text}" + "의 원부조회 결과"
            }

        }
        
        return binding.root
    }

}