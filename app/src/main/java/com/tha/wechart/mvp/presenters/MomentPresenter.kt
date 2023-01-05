package com.tha.wechart.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.tha.wechart.mvp.views.MomentView

interface MomentPresenter {

    fun initView(view: MomentView)
    fun onUiReady(context: Context,owner: LifecycleOwner)

}