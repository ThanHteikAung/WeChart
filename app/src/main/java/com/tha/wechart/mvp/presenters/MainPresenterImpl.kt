package com.tha.wechart.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.wechart.mvp.views.MainView

class MainPresenterImpl : ViewModel(), MainPresenter {

    private lateinit var mView: MainView

    override fun initView(view: MainView) {
        mView = view
    }

    override fun onTapLogin() {
        mView.navigateToLogin()
    }


}