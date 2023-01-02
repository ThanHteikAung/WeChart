package com.tha.wechart.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tha.wechart.R
import com.tha.wechart.fragments.*
import com.tha.wechart.mvp.presenters.MainFragmentPresenter
import com.tha.wechart.mvp.presenters.MainFragmentPresenterImpl
import com.tha.wechart.mvp.views.MainFragmentView
import kotlinx.android.synthetic.main.activity_main_fragment.*

class MainFragmentActivity : AppCompatActivity(), MainFragmentView {

    private lateinit var mPresenter: MainFragmentPresenter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainFragmentActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)
        setUpPresenter()
        swiftFragment(MomentFragment())
        setUpBottomNavigationListener()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[MainFragmentPresenterImpl::class.java]
        mPresenter.initial(this)
    }

    //setup bottomNavigation listener
    private fun setUpBottomNavigationListener() {
        bottomNavigate.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.momentMenu -> {
                    mPresenter.navigateToMoment(MomentFragment())
                }
                R.id.chatMenu -> {
                    mPresenter.navigateToChat(ChatFragment())
                }
                R.id.contactsMenu -> {
                    mPresenter.navigateToContacts(ContactsFragment())
                }
                R.id.meAccMenu -> {
                    mPresenter.navigateToMeAcc(MeFragment())
                }
                R.id.settingMenu -> {
                    mPresenter.navigateToSetting(SettingFragment())
                }
            }
            true
        }
    }

    private fun swiftFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFrameLayout, fragment)
            .commit()
    }

    override fun showFragment(fragment: Fragment) {
        swiftFragment(fragment)
    }


}