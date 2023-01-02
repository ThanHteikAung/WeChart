package com.tha.wechart.data.vos

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
class RegisterVO(
    var phNo: String? = "",
    var name: String? = "",
    var pass: String? = "",
    var dateOfBirth: String? = "",
    var gender: String? = ""
)