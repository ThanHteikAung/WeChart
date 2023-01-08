package com.tha.wechart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tha.wechart.R
import com.tha.wechart.delegates.AddGroupContactDelegate
import com.tha.wechart.view.viewholders.ContactsViewHolder

class ContactsAdapter(private val mDelegate: AddGroupContactDelegate) :
    BaseRecyclerAdapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_contact_group_item, parent, false)
        return ContactsViewHolder(view, mDelegate)
    }

}