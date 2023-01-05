package com.tha.wechart.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.wechart.mvp.views.CreateGroupView

class CreateGroupPresenterImpl : ViewModel(), CreateGroupPresenter {

    private lateinit var mView: CreateGroupView

    override fun initView(view: CreateGroupView) {
        mView = view
    }

}