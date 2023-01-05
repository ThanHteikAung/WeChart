package com.tha.wechart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tha.wechart.R
import com.tha.wechart.view.viewholders.ContactsListViewHolder

class ContactsListAdapter : BaseRecyclerAdapter<ContactsListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_contact_list_item, parent, false)
        return ContactsListViewHolder(view)
    }
}