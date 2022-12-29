package com.tha.wechart.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tha.wechart.R
import com.tha.wechart.adapters.MomentAdapter
import kotlinx.android.synthetic.main.fragment_moment.*

class MomentFragment : Fragment() {

    private lateinit var mMomentAdapter: MomentAdapter

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
        setUpMomentRecycler()
    }

    //setup Moment Recycler
    private fun setUpMomentRecycler() {
        mMomentAdapter = MomentAdapter()
        rvMoment.adapter = mMomentAdapter
        rvMoment.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}