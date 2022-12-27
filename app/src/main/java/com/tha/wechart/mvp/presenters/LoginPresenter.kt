package com.tha.wechart.mvp.presenters

import com.tha.wechart.mvp.views.LoginView

interface LoginPresenter {

    fun initView(view: LoginView)
    fun onTapBackToMain()

}