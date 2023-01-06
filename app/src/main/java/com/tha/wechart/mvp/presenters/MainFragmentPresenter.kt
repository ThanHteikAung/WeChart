package com.tha.wechart.mvp.presenters

import androidx.fragment.app.Fragment
import com.tha.wechart.mvp.views.MainFragmentView

interface MainFragmentPresenter {

    fun initial(view: MainFragmentView)
    fun navigateToMoment(fragment: Fragment)
    fun navigateToChat(fragment: Fragment)
    fun navigateToContacts(fragment: Fragment)
    fun navigateToMeAcc(fragment: Fragment)
    fun navigateToSetting(fragment: Fragment)
    fun navigateToCreateMoment()
    fun navigateToCreateContactGroup()
    fun navigateToChatRoomActivity()

}