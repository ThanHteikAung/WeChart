package com.tha.wechart.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tha.wechart.R
import com.tha.wechart.data.vos.UserVO
import com.tha.wechart.view.viewholders.CreateContactListViewHolder

class CreateContactListAdapter : BaseRecyclerAdapter<CreateContactListViewHolder>() {

    private var mCreateContactList: List<UserVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateContactListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_create_contact_list_item, parent, false)
        return CreateContactListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CreateContactListViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bindData(mCreateContactList[position])
    }

    override fun getItemCount(): Int {
        return mCreateContactList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(contactList: List<UserVO>) {
        mCreateContactList = contactList
        notifyDataSetChanged()
    }
}
