package com.tha.wechart.mvp.presenters

import android.graphics.Bitmap
import com.tha.wechart.delegates.AddImageDelegate
import com.tha.wechart.mvp.views.CreateMomentView

interface CreateMomentPresenter: AddImageDelegate {

    fun initView(view: CreateMomentView)
    fun onTapCreate(postTime: String, textContact: String)
    fun onPhotoTaken(bitmap: Bitmap)

}