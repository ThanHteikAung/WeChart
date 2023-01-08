package com.tha.wechart.mvp.views

import com.tha.wechart.data.vos.UserVO

interface CreateGroupView {

    fun showCreateContactList(friendList: List<UserVO>)

}