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
                    swiftAppBar("Moments", R.drawable.ic_baseline_post_add_white_24dp)
                }
                R.id.chatMenu -> {
                    mPresenter.navigateToChat(ChatFragment())
                    swiftAppBar("Chats", R.drawable.ic_baseline_search_white_24dp)
                }
                R.id.contactsMenu -> {
                    mPresenter.navigateToContacts(ContactsFragment())
                    swiftAppBar("Contacts", R.drawable.ic_baseline_person_add_alt_1_white_24dp)
                }
                R.id.meAccMenu -> {
                    mPresenter.navigateToMeAcc(MeFragment())
                    swiftAppBar("Me", R.drawable.ic_baseline_edit_white_24dp)
                }
                R.id.settingMenu -> {
                    mPresenter.navigateToSetting(SettingFragment())
                    swiftAppBar("Setting", R.drawable.ic_baseline_settings_white_24dp)
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

    //swift appbar title and icon
    private fun swiftAppBar(title: String, iconImage: Int) {
        txtAppBarTitle.text = title
        btnAppBarIcon.setImageResource(iconImage)
    }

    override fun showFragment(fragment: Fragment) {
        swiftFragment(fragment)
    }


}