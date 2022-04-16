package com.example.adviceapp.data

import com.example.adviceapp.model.Slip

interface AdviceCallBack {
    fun onSuccess(advice: Slip)
    fun onError(msg : String)
    fun onCompleted()
}
