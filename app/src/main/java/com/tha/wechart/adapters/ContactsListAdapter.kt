package com.tha.wechart.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tha.wechart.R
import com.tha.wechart.data.vos.UserVO
import com.tha.wechart.view.viewholders.ContactsListViewHolder

class ContactsListAdapter : BaseRecyclerAdapter<ContactsListViewHolder>() {

    private var mContactList : List<UserVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_contact_list_item, parent, false)
        return ContactsListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactsListViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bindData(mContactList[position])
    }

    override fun getItemCount(): Int {
        return mContactList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(contactList: List<UserVO>) {
        mContactList = contactList
        notifyDataSetChanged()
    }
}