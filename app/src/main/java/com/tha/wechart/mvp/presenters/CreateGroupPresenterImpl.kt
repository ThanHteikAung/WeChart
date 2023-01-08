package com.tha.wechart.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.tha.wechart.data.modals.RegisterModel
import com.tha.wechart.data.modals.RegisterModelImpl
import com.tha.wechart.mvp.views.CreateGroupView

class CreateGroupPresenterImpl : ViewModel(), CreateGroupPresenter {

    private lateinit var mView: CreateGroupView
    private var mModel: RegisterModel = RegisterModelImpl

    override fun initView(view: CreateGroupView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mModel.getFriendList(
            onSuccess = {
                mView.showCreateContactList(it)
            },
            onFailure = {
                // show Error
            }
        )
    }

}