package com.tha.wechart.mvp.presenters

import com.tha.wechart.mvp.views.MeView

interface MePresenter {

    fun initView(view: MeView)
    fun getUserRegister()

}