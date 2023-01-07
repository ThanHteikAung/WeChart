package com.tha.wechart.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.wechart.data.modals.RegisterModel
import com.tha.wechart.data.modals.RegisterModelImpl
import com.tha.wechart.mvp.views.MeView

class MePresenterImpl : ViewModel(), MePresenter {

    private lateinit var mView: MeView
    private val mModel: RegisterModel = RegisterModelImpl

    override fun initView(view: MeView) {
        mView = view
    }

    override fun getUserRegister() {
        mModel.getUserRegister(
            onSuccess = {
                mView.bindData(it)
            },
            onFailure = {
                //show Error
            }
        )
    }

}