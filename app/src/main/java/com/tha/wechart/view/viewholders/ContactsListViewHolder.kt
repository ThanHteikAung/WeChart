package com.tha.wechart.view.viewholders

import android.view.View
import com.tha.wechart.data.vos.UserVO
import kotlinx.android.synthetic.main.view_holder_contact_list_item.view.*

class ContactsListViewHolder(itemView: View) : BaseViewHolder(itemView) {

    fun bindData(contact: UserVO){
        itemView.tvContactName.text = contact.name
    }

}