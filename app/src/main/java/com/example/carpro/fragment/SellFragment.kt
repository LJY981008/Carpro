package com.example.carpro.fragment

import android.Manifest
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.ClipData
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.example.carpro.R
import com.example.carpro.Util
import com.example.carpro.databinding.FragmentSellBinding
import com.example.carpro.saleList.Information
import java.text.FieldPosition

class SellFragment : Fragment() {

    private lateinit var binding: FragmentSellBinding
    private lateinit var spinner: Spinner
    private lateinit var carType: String
    private lateinit var getResult: ActivityResultLauncher<Intent>
    private var uriData: MutableList<Uri> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentSellBinding.inflate(inflater, container, false)

        spinner = binding.typeCar
        spinner.adapter = ArrayAdapter.createFromResource(
            container!!.context,
            R.array.carList,
            android.R.layout.simple_spinner_item
        )
        /**
         * 차종 받아서 매물조회리스트에 추가
         */
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                carType = spinner.selectedItem.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        getResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback {
                if (it.resultCode == RESULT_OK) {
                    it.data?.clipData?.let { it ->
                        for (i in 0 until it.itemCount) {
                            uriData.add(it.getItemAt(i).uri)
                            binding.tvImageName.text =
                                "${binding.tvImageName.text}" + ", " + "${it.getItemAt(i).uri.lastPathSegment}"
                        }
                    }

                    it.data?.data?.let { it ->
                        uriData.add(it)
                        uriData.size
                        binding.tvImageName.text = "${it.lastPathSegment}"
                    }
                }
            })

        binding.btnUploadImage.setOnClickListener {
            openGallery()
        }

        binding.btnComplete.setOnClickListener {
            if (!binding.editPrice.text.isNullOrEmpty()) {
                if (uriData.size == 0) {
                    Toast.makeText(context, "사진을 등록해주세요.", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Util.carInfo.add(
                        Information(
                            carType,
                            binding.editPrice.text.toString(),
                            uriData,
                            binding.editCarIntroduce.text.toString()
                        )
                    )
                    Toast.makeText(context, "차량이 등록되었습니다", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(binding.root)
                        .navigate(R.id.action_global_mainFragment)
                }
            } else {
                Toast.makeText(context, "원하는 가격을 입력해주세요.", Toast.LENGTH_SHORT).show()
            }

        }

        return binding.root
    }

    private fun openGallery() {

        getResult.launch(Intent(Intent.ACTION_GET_CONTENT).apply {
            putExtra(
                Intent.EXTRA_ALLOW_MULTIPLE,
                true
            )
            type =
                "image/*"
        })

    }

}