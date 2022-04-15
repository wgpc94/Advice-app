package com.example.adviceapp.data

import android.os.Handler
import android.os.Looper
import com.example.adviceapp.model.Advice

class RemoteDataSource{
    fun findRandom(callBack: AdviceCallBack) {
        var id = 0
        id ++
        Handler(Looper.getMainLooper()).postDelayed(
            {
                callBack.onSuccess(Advice(id, "Hello"))
                callBack.onCompleted()
            }
        ,1000
        )

    }

}