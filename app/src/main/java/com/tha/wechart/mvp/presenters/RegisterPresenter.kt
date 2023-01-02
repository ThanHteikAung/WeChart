package com.tha.wechart.mvp.presenters

import com.tha.wechart.mvp.views.RegisterView

interface RegisterPresenter {

    fun initial(view: RegisterView)
    fun onTapVerifyRegister(
        phNo: String,
        name: String,
        dateOfBirth: String,
        gender: String,
        pass: String
    )

}