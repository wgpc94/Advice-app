package com.example.adviceapp.data

import com.example.adviceapp.model.Advice
import com.example.adviceapp.model.Slip
import retrofit2.Call
import retrofit2.http.GET

interface AdviceApi {
    @GET("/advice")
    fun getAdvice() : Call<Slip>
}