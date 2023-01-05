package com.tha.wechart.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tha.wechart.R
import com.tha.wechart.activities.CreateGroupActivity
import com.tha.wechart.adapters.ContactsAdapter
import com.tha.wechart.adapters.ContactsListAdapter
import com.tha.wechart.mvp.presenters.ContactsPresenter
import com.tha.wechart.mvp.presenters.ContactsPresenterImpl
import com.tha.wechart.mvp.views.ContactsView
import kotlinx.android.synthetic.main.fragment_contacts.*

class ContactsFragment : Fragment(), ContactsView {

    private lateinit var mPresenter: ContactsPresenter
    private lateinit var mContactsAdapter: ContactsAdapter
    private lateinit var mContactsListAdapter: ContactsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpAddGroupRecycler()
        setUpContactListRecycler()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[ContactsPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpAddGroupRecycler() {
        mContactsAdapter = ContactsAdapter()
        rvGroupCreate.adapter = mContactsAdapter
        rvGroupCreate.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setUpContactListRecycler() {
        mContactsListAdapter = ContactsListAdapter()
        rvContactsList.adapter = mContactsListAdapter
        rvContactsList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun navigateToCreateGroupScreen() {
        startActivity(context?.let { CreateGroupActivity.newIntent(it) })
    }

}