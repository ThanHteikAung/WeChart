package com.tha.wechart.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.wechart.mvp.views.ContactsView

class ContactsPresenterImpl : ViewModel(), ContactsPresenter {

    private lateinit var mView: ContactsView

    override fun initView(view: ContactsView) {
        mView = view
    }
}