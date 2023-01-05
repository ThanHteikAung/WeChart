package com.tha.wechart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tha.wechart.R
import com.tha.wechart.view.viewholders.SelectContactsListViewHolder

class SelectContactsListAdapter : BaseRecyclerAdapter<SelectContactsListViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectContactsListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_selected_contact_item, parent, false)
        return SelectContactsListViewHolder(view)
    }
}