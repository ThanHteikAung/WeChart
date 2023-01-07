package com.tha.wechart.data.modals

import android.graphics.Bitmap
import com.tha.wechart.data.vos.UserVO
import network.CloudFireStoreFirebaseApiImpl
import network.FirebaseApi

object RegisterModelImpl : RegisterModel {

    private val mCloudFireStoreFirebaseApiImpl: FirebaseApi = CloudFireStoreFirebaseApiImpl
    private var mImage = arrayListOf<String>()
    private lateinit var mPhone: String

    override fun addRegister(
        phNo: String,
        name: String,
        dateOfBirth: String,
        gender: String,
        pass: String
    ) {
        mCloudFireStoreFirebaseApiImpl.addRegister(phNo, name, dateOfBirth, gender, pass)
    }

    override fun addMoment(postTime: Long, textContact: String) {
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
        mPhone = phNo
        mCloudFireStoreFirebaseApiImpl.getRegister(phNo, pass, onSuccess, onFailure)
    }

    override fun getUserData(
        onSuccess: (userDataList: List<UserVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mCloudFireStoreFirebaseApiImpl.getUserData(mPhone, onSuccess, onFailure)
    }

    override fun getUserRegister(
        onSuccess: (register: UserVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mCloudFireStoreFirebaseApiImpl.getUserRegister(mPhone, onSuccess, onFailure)
    }
}