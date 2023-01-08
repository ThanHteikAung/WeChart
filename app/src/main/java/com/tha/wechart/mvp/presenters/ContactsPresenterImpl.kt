package com.tha.wechart.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.tha.wechart.data.modals.RegisterModel
import com.tha.wechart.data.modals.RegisterModelImpl
import com.tha.wechart.mvp.views.ContactsView

class ContactsPresenterImpl : ViewModel(), ContactsPresenter {

    private lateinit var mView: ContactsView
    private var mModel: RegisterModel = RegisterModelImpl

    override fun initView(view: ContactsView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mModel.getFriendList(
            onSuccess = {
                mView.showContactList(it)
            },
            onFailure = {
                // show Error
            }
        )
    }

    override fun onTapAddGroup() {
        mView.navigateToCreateGroupScreen()
    }

}