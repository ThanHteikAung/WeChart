package com.tha.wechart.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.tha.wechart.data.modals.RegisterModel
import com.tha.wechart.data.modals.RegisterModelImpl
import com.tha.wechart.mvp.views.MomentView

class MomentPresenterImpl : ViewModel(), MomentPresenter {

    private lateinit var mView: MomentView
    private val mModel: RegisterModel = RegisterModelImpl

    override fun initView(view: MomentView) {
        mView = view
    }

    override fun onUiReady(context: Context, owner: LifecycleOwner) {
        mModel.getUserData(
            onSuccess = {
                mView.showMomentList(it)
            },
            onFailure = {
                //Show error
            }
        )
    }


}