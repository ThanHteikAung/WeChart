package com.tha.wechart.mvp.presenters

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.tha.wechart.mvp.views.MainFragmentView

class MainFragmentPresenterImpl : ViewModel(), MainFragmentPresenter {

    private lateinit var mView: MainFragmentView

    override fun initial(view: MainFragmentView) {
        mView = view
    }

    override fun navigateToMoment(fragment: Fragment) {
        mView.showFragment(fragment)
    }

    override fun navigateToChat(fragment: Fragment) {
        mView.showFragment(fragment)
    }

    override fun navigateToContacts(fragment: Fragment) {
        mView.showFragment(fragment)
    }

    override fun navigateToMeAcc(fragment: Fragment) {
        mView.showFragment(fragment)
    }

    override fun navigateToSetting(fragment: Fragment) {
        mView.showFragment(fragment)
    }

    override fun navigateToCreateMoment() {
        mView.showCreateMoment()
    }

    override fun navigateToCreateContactGroup() {
        mView.showCreateContactGroup()
    }

    override fun navigateToChatRoomActivity() {
        mView.showChartRoom()
    }

    override fun navigateToQRCodeScanner() {
        mView.showQrScanner()
    }
}