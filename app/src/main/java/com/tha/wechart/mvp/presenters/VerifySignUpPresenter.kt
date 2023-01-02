package com.tha.wechart.mvp.presenters

import com.tha.wechart.mvp.views.VerifySignUpView

interface VerifySignUpPresenter {

    fun initial(view: VerifySignUpView)
    fun onTapVerifySignUpRegister()
    fun onTapGetOTP()

}