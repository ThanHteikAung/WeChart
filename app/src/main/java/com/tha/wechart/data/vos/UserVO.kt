package com.tha.wechart.data.vos

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
class UserVO(
    var phNo: String? = "",
    var name: String? = "",
    var pass: String? = "",
    var dateOfBirth: String? = "",
    var gender: String? = "",
    var textContext: String? = "",
    var imageUrl: ArrayList<String>? = null,
    var postTime: Long? = 0
)