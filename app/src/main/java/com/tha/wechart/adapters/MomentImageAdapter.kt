package com.tha.wechart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tha.wechart.R
import com.tha.wechart.view.viewholders.MomentImageViewHolder

class MomentImageAdapter : BaseRecyclerAdapter<MomentImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_moment_image_item, parent, false)
        return MomentImageViewHolder(view)
    }


}