package com.tha.wechart.data.modals

import network.CloudFireStoreFirebaseApiImpl
import network.FirebaseApi

object RegisterModelImpl : RegisterModel {

    private val mCloudFireStoreFirebaseApiImpl: FirebaseApi = CloudFireStoreFirebaseApiImpl

    override fun addRegister(
        phNo: String,
        name: String,
        dateOfBirth: String,
        gender: String,
        pass: String
    ) {
        mCloudFireStoreFirebaseApiImpl.addRegister(phNo, name, dateOfBirth, gender, pass)
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