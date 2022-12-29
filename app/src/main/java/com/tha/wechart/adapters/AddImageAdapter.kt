package com.tha.wechart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tha.wechart.R
import com.tha.wechart.view.viewholders.AddImageViewHolder

class AddImageAdapter : BaseRecyclerAdapter<AddImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_add_image_item, parent, false)
        return AddImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: AddImageViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        if (position == 1) {
            holder.addImage.setImageResource(R.drawable.ic_baseline_add_24dp)
            holder.addImage.setBackgroundResource(R.drawable.rounded_four_corner_button)
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}