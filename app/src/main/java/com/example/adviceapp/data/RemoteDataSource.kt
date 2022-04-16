package com.example.adviceapp.data

import com.example.adviceapp.model.Slip
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource{
    fun findRandom(callBack: AdviceCallBack) {

        HTTPClient.retrofit()
            .create(AdviceApi::class.java)
            .getAdvice()
            .enqueue(object : Callback<Slip>{
                override fun onResponse(call: Call<Slip>, response: Response<Slip>) {
                    if (response.isSuccessful){
                        val slip = response.body()!!
                        callBack.onSuccess(slip)
                    }else{
                        callBack.onError(response.errorBody()?.string() ?: "Error desconhecido")
                    }
                    callBack.onCompleted()
                }

                override fun onFailure(call: Call<Slip>, t: Throwable) {
                    callBack.onError(t.message ?: "Error no servidor")
                    callBack.onCompleted()
                }


            })


        /*var id = 0
        id ++
        Handler(Looper.getMainLooper()).postDelayed(
            {
                callBack.onSuccess(Advice(id, "Hello"))
                callBack.onCompleted()
            }
        ,1000
        )
         */

    }

}