package com.tha.wechart.data.modals

import android.graphics.Bitmap
import network.CloudFireStoreFirebaseApiImpl
import network.FirebaseApi

object RegisterModelImpl : RegisterModel {

    private val mCloudFireStoreFirebaseApiImpl: FirebaseApi = CloudFireStoreFirebaseApiImpl
    private var mImage = arrayListOf<String>()

    override fun addRegister(
        phNo: String,
        name: String,
        dateOfBirth: String,
        gender: String,
        pass: String
    ) {
        mCloudFireStoreFirebaseApiImpl.addRegister(phNo, name, dateOfBirth, gender, pass)
    }

    override fun addMoment(postTime: String, textContact: String) {
        mCloudFireStoreFirebaseApiImpl.addMoment(postTime, textContact, mImage)
    }

    override fun uploadImageGrocery(
        image: Bitmap,
        onSuccess: (ArrayList<String>) -> Unit
    ) {
        mCloudFireStoreFirebaseApiImpl.uploadImageAndEditGrocery(
            image,
            onSuccess = {
                mImage = ArrayList(it)
                onSuccess(it)
            })
    }

    override fun getRegister(
        phNo: String,
        pass: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mCloudFireStoreFirebaseApiImpl.getRegister(phNo, pass, onSuccess, onFailure)
    }
}