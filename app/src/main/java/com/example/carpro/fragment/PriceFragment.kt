package com.example.carpro.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.carpro.R
import com.example.carpro.Util
import com.example.carpro.databinding.FragmentPriceBinding
import com.example.carpro.saleList.SaleAdapter
import com.example.carpro.saleList.SaleInfo
import kotlinx.android.synthetic.main.fragment_price.*

class PriceFragment : Fragment() {
    private lateinit var binding: FragmentPriceBinding
    private lateinit var spinner: Spinner
    private lateinit var adapter: SaleAdapter
    private lateinit var carType: String

    private var list: MutableList<SaleInfo> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPriceBinding.inflate(inflater, container, false)
        adapter = SaleAdapter(list)

        binding.viewCarlist.adapter = adapter

        spinner = binding.spinnerTypeCar
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
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        binding.radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.radio_Car -> {
                    binding.LinearTypeCar.visibility = View.VISIBLE
                    binding.LinearTypePrice.visibility = View.INVISIBLE
                }
                R.id.radio_Price -> {
                    binding.LinearTypeCar.visibility = View.INVISIBLE
                    binding.LinearTypePrice.visibility = View.VISIBLE
                }
            }

        }

        binding.btnTypeCarSearch.setOnClickListener {
            list.clear()
            for (j in 0 until Util.carInfo.size) {
                if (Util.carInfo[j].carType == binding.spinnerTypeCar.selectedItem) {
                    //배열에 값추가
                    list.add(
                        SaleInfo(
                            Util.carInfo[j].carType,
                            Util.carInfo[j].carPrice,
                            Util.carInfo[j].carUri,
                            Util.carInfo[j].carIntroduce
                        )
                    )
                }
            }
            adapter.notifyDataSetChanged()
        }
        binding.btnPriceSearch.setOnClickListener {
            list.clear()

            if (binding.editPrice.text.isNullOrEmpty()) {
                Toast.makeText(context, "가격을 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                when (binding.radioGroupPrice.checkedRadioButtonId) {
                    R.id.radio_Plus -> {
                        var price: Int = binding.editPrice.text.toString().toInt()
                        for (j in 0 until Util.carInfo.size) {
                            if (Util.carInfo[j].carPrice.toInt() >= price) {
                                //배열에 값추가
                                list.add(
                                    SaleInfo(
                                        Util.carInfo[j].carType,
                                        Util.carInfo[j].carPrice,
                                        Util.carInfo[j].carUri,
                                        Util.carInfo[j].carIntroduce
                                    )
                                )
                            }
                        }
                    }
                    R.id.radio_Subtract -> {
                        var price: Int = binding.editPrice.text.toString().toInt()
                        for (j in 0 until Util.carInfo.size) {
                            if (Util.carInfo[j].carPrice.toInt() <= price) {
                                //배열에 값추가
                                list.add(
                                    SaleInfo(
                                        Util.carInfo[j].carType,
                                        Util.carInfo[j].carPrice,
                                        Util.carInfo[j].carUri,
                                        Util.carInfo[j].carIntroduce
                                    )
                                )
                            }
                        }
                    }
                }
                adapter.notifyDataSetChanged()
            }
        }




        return binding.root
    }
}