package com.tha.wechart.mvp.presenters

import com.tha.wechart.mvp.views.MainView

interface MainPresenter {

    fun initView(view: MainView)
    fun onTapLogin()
    fun onTapSignUp()

}