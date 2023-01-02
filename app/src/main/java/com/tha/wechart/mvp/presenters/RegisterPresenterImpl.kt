package com.tha.wechart.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.wechart.data.modals.RegisterModel
import com.tha.wechart.data.modals.RegisterModelImpl
import com.tha.wechart.mvp.views.RegisterView

class RegisterPresenterImpl : ViewModel(), RegisterPresenter {

    private lateinit var mView: RegisterView
    private val mModel: RegisterModel = RegisterModelImpl

    override fun initial(view: RegisterView) {
        mView = view
    }

    override fun onTapVerifyRegister(
        phNo: String,
        name: String,
        dateOfBirth: String,
        gender: String,
        pass: String
    ) {
        mModel.addRegister(phNo, name, dateOfBirth, gender, pass)
        mView.addRegister()
    }
}