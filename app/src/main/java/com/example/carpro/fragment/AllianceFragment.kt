package com.example.carpro.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.carpro.R
import com.example.carpro.allianceList.AllianceAdapter
import com.example.carpro.allianceList.AllianceInfo
import com.example.carpro.databinding.FragmentAllianceBinding

class AllianceFragment : Fragment() {
    private lateinit var binding: FragmentAllianceBinding
    private lateinit var adapter: AllianceAdapter
    private val allianceList: MutableList<AllianceInfo> = mutableListOf(
        /*AllianceInfo(
            ContextCompat.getDrawable(
                requireActivity(),
                R.drawable.img
            )!!, "홍길동", "010-1234-5678"
        ),
        AllianceInfo(
            ContextCompat.getDrawable(
                requireActivity(),
                R.drawable.img
            )!!, "황진이", "010-3456-2345"
        ),
        AllianceInfo(
            ContextCompat.getDrawable(
                requireActivity(),
                R.drawable.img
            )!!, "이순신", "010-5678-5432"
        )*/
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllianceBinding.inflate(inflater, container, false)
        allianceList.add(
            AllianceInfo(
                ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.img
                )!!, "홍길동", "010-1234-5678"
            )
        )
        allianceList.add(
            AllianceInfo(
                ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.img
                )!!, "황진이", "010-3456-2345"
            )
        )
        allianceList.add(
            AllianceInfo(
                ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.img
                )!!, "이순신", "010-5678-5432"
            )
        )
        adapter = AllianceAdapter(allianceList)
        binding.listAlliance.adapter = adapter
        return binding.root
    }
}