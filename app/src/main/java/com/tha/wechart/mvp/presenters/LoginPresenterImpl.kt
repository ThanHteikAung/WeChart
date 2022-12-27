package com.tha.wechart.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.wechart.mvp.views.LoginView

class LoginPresenterImpl : ViewModel(), LoginPresenter {

    private lateinit var mView: LoginView

    override fun initView(view: LoginView) {
        mView = view
    }

    override fun onTapBackToMain() {
        mView.navigateToMainScreen()
    }


}