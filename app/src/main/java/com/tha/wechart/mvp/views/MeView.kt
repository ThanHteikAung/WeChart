package com.tha.wechart.mvp.views

import com.tha.wechart.data.vos.UserVO

interface MeView {

    fun bindData(register: UserVO)
}