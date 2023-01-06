package com.tha.wechart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tha.wechart.R
import com.tha.wechart.view.viewholders.ChatsViewHolder

class ChatsAdapter : BaseRecyclerAdapter<ChatsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_chat_item, parent, false)
        return ChatsViewHolder(view)
    }
}