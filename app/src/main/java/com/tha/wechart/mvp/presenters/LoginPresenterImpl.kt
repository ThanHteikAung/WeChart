package com.tha.wechart.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.wechart.data.modals.RegisterModel
import com.tha.wechart.data.modals.RegisterModelImpl
import com.tha.wechart.mvp.views.LoginView

class LoginPresenterImpl : ViewModel(), LoginPresenter {

    private lateinit var mView: LoginView
    private val mModel: RegisterModel = RegisterModelImpl

    override fun initView(view: LoginView) {
        mView = view
    }

    override fun onTapBackToMain() {
        mView.navigateToMainScreen()
    }

    override fun onTapLogin(phNo: String, pass: String) {
        mModel.getRegister(
            phNo,
            pass,
            onSuccess = {
                mView.navigateToMomentScreen()
            },
            onFailure = {
                mView.showError(it)
            }
        )
    }


}