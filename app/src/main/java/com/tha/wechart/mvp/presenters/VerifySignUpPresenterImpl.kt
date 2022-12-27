package com.tha.wechart.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.wechart.mvp.views.VerifySignUpView

class VerifySignUpPresenterImpl : ViewModel(), VerifySignUpPresenter {

    private lateinit var mView: VerifySignUpView

    override fun initial(view: VerifySignUpView) {
        mView = view
    }
}