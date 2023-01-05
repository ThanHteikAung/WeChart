package com.tha.wechart.mvp.presenters

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.tha.wechart.data.modals.RegisterModel
import com.tha.wechart.data.modals.RegisterModelImpl
import com.tha.wechart.mvp.views.CreateMomentView

class CreateMomentPresenterImpl : ViewModel(), CreateMomentPresenter {

    private lateinit var mView: CreateMomentView
    private val mModel: RegisterModel = RegisterModelImpl

    override fun initView(view: CreateMomentView) {
        mView = view
    }

    override fun onTapCreate(postTime: Long, textContact: String) {
        mModel.addMoment(postTime, textContact)
        mView.navigateToMoment()
    }

    override fun onPhotoTaken(bitmap: Bitmap) {
        mModel.uploadImageGrocery(
            bitmap,
            onSuccess = {
            mView.showSelectedImage(it)
        })
    }

    override fun onTapFileUpload() {
        mView.openGallery()
    }

}