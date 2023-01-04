package com.tha.wechart.mvp.views

interface CreateMomentView {

    fun navigateToMoment()
    fun openGallery()
    fun showSelectedImage(imageUriList: ArrayList<String>)

}