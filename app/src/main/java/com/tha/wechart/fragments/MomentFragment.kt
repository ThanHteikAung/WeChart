package com.tha.wechart.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tha.wechart.R
import com.tha.wechart.adapters.MomentAdapter
import com.tha.wechart.data.vos.UserVO
import com.tha.wechart.mvp.presenters.MomentPresenter
import com.tha.wechart.mvp.presenters.MomentPresenterImpl
import com.tha.wechart.mvp.views.MomentView
import kotlinx.android.synthetic.main.fragment_moment.*

class MomentFragment : Fragment(), MomentView {

    private lateinit var mMomentAdapter: MomentAdapter
    private lateinit var mPresenter: MomentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_moment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpMomentRecycler()

        context?.let { mPresenter.onUiReady(it, this) }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[MomentPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    //setup Moment Recycler
    private fun setUpMomentRecycler() {
        mMomentAdapter = MomentAdapter()
        rvMoment.adapter = mMomentAdapter
        rvMoment.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun showMomentList(userMomentList: List<UserVO>) {
        mMomentAdapter.setNewData(userMomentList)
    }
}