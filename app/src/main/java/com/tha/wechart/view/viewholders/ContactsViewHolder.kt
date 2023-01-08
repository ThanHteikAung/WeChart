package com.tha.wechart.view.viewholders

import android.view.View
import com.tha.wechart.delegates.AddGroupContactDelegate
import kotlinx.android.synthetic.main.view_holder_contact_group_item.view.*

class ContactsViewHolder(itemView: View, private val mDelegate: AddGroupContactDelegate) :
    BaseViewHolder(itemView) {

        init {
            itemView.ivGroup.setOnClickListener {
                mDelegate.onTapAddGroup()
            }
        }

}