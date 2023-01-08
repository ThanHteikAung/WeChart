package com.tha.wechart.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.tha.wechart.mvp.views.CreateGroupView

interface CreateGroupPresenter {

    fun initView(view: CreateGroupView)
    fun onUiReady(owner: LifecycleOwner)

}