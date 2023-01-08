package com.tha.wechart.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tha.wechart.R
import com.tha.wechart.adapters.CreateContactListAdapter
import com.tha.wechart.adapters.SelectContactsListAdapter
import com.tha.wechart.data.vos.UserVO
import com.tha.wechart.mvp.presenters.CreateGroupPresenter
import com.tha.wechart.mvp.presenters.CreateGroupPresenterImpl
import com.tha.wechart.mvp.views.CreateGroupView
import kotlinx.android.synthetic.main.activity_create_group.*

class CreateGroupActivity : AppCompatActivity(), CreateGroupView {

    private lateinit var mSelectContactsListAdapter: SelectContactsListAdapter
    private lateinit var mPresenter: CreateGroupPresenter
    private lateinit var mContactsListAdapter: CreateContactListAdapter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CreateGroupActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_group)
        setUpPresenter()
        setUpSelectedRecycler()
        setUpContactListRecycler()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[CreateGroupPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpSelectedRecycler() {
        mSelectContactsListAdapter = SelectContactsListAdapter()
        rvSelectedContact.adapter = mSelectContactsListAdapter
        rvSelectedContact.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setUpContactListRecycler() {
        mContactsListAdapter = CreateContactListAdapter()
        rvContactsList.adapter = mContactsListAdapter
        rvContactsList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun showCreateContactList(friendList: List<UserVO>) {
        mContactsListAdapter.setNewData(friendList)
    }


}