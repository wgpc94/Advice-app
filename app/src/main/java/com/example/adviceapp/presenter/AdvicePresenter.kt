package com.example.adviceapp.presenter

import com.example.adviceapp.data.AdviceCallBack
import com.example.adviceapp.data.RemoteDataSource
import com.example.adviceapp.model.Slip
import com.example.adviceapp.view.MainActivity

class AdvicePresenter(private val mainActivity: MainActivity) : AdviceCallBack{
    private val dataSource = RemoteDataSource()
    fun findRandom() {
        mainActivity.showProgress()
        dataSource.findRandom(this)
    }

    override fun onSuccess(slip: Slip) {
        mainActivity.showAdvice(slip.advice)
    }

    override fun onError(msg: String) {
        mainActivity.showFailure(msg)
    }

    override fun onCompleted() {
        mainActivity.hideProgress()
    }

}