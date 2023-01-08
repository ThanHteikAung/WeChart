package com.tha.wechart.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.tha.wechart.delegates.AddGroupContactDelegate
import com.tha.wechart.mvp.views.ContactsView

interface ContactsPresenter : AddGroupContactDelegate {

    fun initView(view: ContactsView)
    fun onUiReady(owner: LifecycleOwner)

}