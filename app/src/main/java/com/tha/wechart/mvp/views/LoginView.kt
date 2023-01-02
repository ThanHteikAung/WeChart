package com.tha.wechart.mvp.views

import com.tha.wechart.data.vos.RegisterVO

interface LoginView: BaseView {
    fun navigateToMainScreen()
    fun navigateToMomentScreen()
}