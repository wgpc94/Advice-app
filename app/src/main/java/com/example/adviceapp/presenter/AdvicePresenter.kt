package com.example.adviceapp.presenter

import com.example.adviceapp.data.AdviceCallBack
import com.example.adviceapp.data.RemoteDataSource
import com.example.adviceapp.model.Advice
import com.example.adviceapp.view.MainActivity

class AdvicePresenter(private val mainActivity: MainActivity) : AdviceCallBack{
    private val dataSource = RemoteDataSource()
    fun findRandom() {
        mainActivity.showProgress()
        dataSource.findRandom(this)
    }

    override fun onSuccess(advice: Advice) {
        mainActivity.showAdvice(advice)
    }

    override fun onError(msg: String) {
        mainActivity.showFailure(msg)
    }

    override fun onCompleted() {
        mainActivity.hideProgress()
    }

}