package com.tha.wechart.data.modals

import android.graphics.Bitmap
import com.tha.wechart.data.vos.UserVO

interface RegisterModel {
    fun addRegister(
        phNo: String,
        name: String,
        dateOfBirth: String,
        gender: String,
        pass: String
    )

    fun addMoment(postTime: Long, textContact: String)

    fun uploadImageGrocery(image: Bitmap, onSuccess: (ArrayList<String>) -> Unit)

    fun getRegister(
        phNo: String,
        pass: String,
        onSuccess: () -> Unit, onFailure: (String) -> Unit
    )

    fun getUserData(
        onSuccess: (userDataList: List<UserVO>) -> Unit,
        onFailure: (String) -> Unit
    )


}