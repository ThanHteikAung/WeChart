package com.tha.wechart.data.modals

interface RegisterModel {
    fun addRegister(
        phNo: String,
        name: String,
        dateOfBirth: String,
        gender: String,
        pass: String
    )

    fun getRegister(
        phNo: String,
        pass: String,
        onSuccess: () -> Unit, onFailure: (String) -> Unit
    )
}