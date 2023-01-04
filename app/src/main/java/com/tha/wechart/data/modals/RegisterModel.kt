package com.tha.wechart.data.modals

import android.graphics.Bitmap

interface RegisterModel {
    fun addRegister(
        phNo: String,
        name: String,
        dateOfBirth: String,
        gender: String,
        pass: String
    )

    fun addMoment(postTime: String, textContact: String)

    fun uploadImageGrocery(image: Bitmap, onSuccess: (ArrayList<String>) -> Unit)

    fun getRegister(
        phNo: String,
        pass: String,
        onSuccess: () -> Unit, onFailure: (String) -> Unit
    )


}