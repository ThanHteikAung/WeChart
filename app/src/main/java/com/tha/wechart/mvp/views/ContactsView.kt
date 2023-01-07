package com.tha.wechart.mvp.views

import com.tha.wechart.data.vos.UserVO

interface ContactsView {

    fun navigateToCreateGroupScreen()
    fun showContactList(friendList: List<UserVO>)
}