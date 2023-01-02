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
}