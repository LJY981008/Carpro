package com.example.carpro.saleList

import android.net.Uri

data class Information(
    var carType: String,
    var carPrice: String,
    var carUri: MutableList<Uri>,
    var carIntroduce: String
)
