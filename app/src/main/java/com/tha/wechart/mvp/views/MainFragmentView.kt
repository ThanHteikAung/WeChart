package com.tha.wechart.mvp.views

import androidx.fragment.app.Fragment

interface MainFragmentView {

    fun showFragment(fragment: Fragment)
    fun showCreateMoment()
    fun showCreateContactGroup()
    fun showChartRoom()

}