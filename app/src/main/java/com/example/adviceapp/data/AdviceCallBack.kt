package com.example.adviceapp.data

import com.example.adviceapp.model.Advice

interface AdviceCallBack {
    fun onSuccess(advice: Advice)
    fun onError(msg : String)
    fun onCompleted()
}
