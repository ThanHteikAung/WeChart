package com.tha.wechart.mvp.views

import com.tha.wechart.data.vos.UserVO

interface MomentView {
    fun showMomentList(userMomentList: List<UserVO>)
}