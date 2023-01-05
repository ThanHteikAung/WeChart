package com.tha.wechart.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tha.wechart.R
import com.tha.wechart.delegates.AddImageDelegate
import com.tha.wechart.view.viewholders.AddImageViewHolder

class AddImageAdapter(private val mDelegate: AddImageDelegate) :
    BaseRecyclerAdapter<AddImageViewHolder>() {

    private var mImageList = arrayListOf<String>()
    var mImageListCount = mImageList.size + 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_add_image_item, parent, false)
        return AddImageViewHolder(view, mDelegate)
    }

    override fun onBindViewHolder(holder: AddImageViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        if (position == mImageListCount - 1) {
            holder.addImage.setImageResource(R.drawable.ic_baseline_add_24dp)
            holder.addImage.setBackgroundResource(R.drawable.rounded_four_corner_stroke_button)
        } else {
            holder.bindData(mImageList[position])
        }
    }

    override fun getItemCount(): Int {
        return mImageListCount
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(imageList: ArrayList<String>) {
        mImageList = imageList
        mImageListCount = mImageList.size + 1
        notifyDataSetChanged()
    }
}