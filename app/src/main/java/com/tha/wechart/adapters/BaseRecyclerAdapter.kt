package com.tha.wechart.adapters

import androidx.recyclerview.widget.RecyclerView
import com.tha.wechart.view.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<T : BaseViewHolder> : RecyclerView.Adapter<T>() {

    override fun onBindViewHolder(holder: T, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }
}