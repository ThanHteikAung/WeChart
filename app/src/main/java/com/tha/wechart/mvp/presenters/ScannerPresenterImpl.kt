package com.tha.wechart.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.wechart.data.modals.RegisterModel
import com.tha.wechart.data.modals.RegisterModelImpl
import com.tha.wechart.mvp.views.ScannerView

class ScannerPresenterImpl : ViewModel(), ScannerPresenter {

    private lateinit var mView: ScannerView
    private var mModel: RegisterModel = RegisterModelImpl

    override fun initView(view: ScannerView) {
        mView = view
    }

    override fun addFriendData(friPhNo: String) {
        mModel.addFriend(friPhNo)
    }


}