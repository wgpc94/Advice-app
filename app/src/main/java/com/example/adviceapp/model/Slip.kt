package com.example.adviceapp.model

import com.google.gson.annotations.SerializedName

data class Slip(
    @SerializedName("slip") val advice: Advice
)