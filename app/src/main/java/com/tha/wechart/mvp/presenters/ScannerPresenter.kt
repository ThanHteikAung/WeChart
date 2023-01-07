package com.tha.wechart.mvp.presenters

import com.tha.wechart.mvp.views.ScannerView

interface ScannerPresenter {

    fun initView(view: ScannerView)
    fun addFriendData(friPhNo: String)

}