package com.tha.wechart.view.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.tha.wechart.delegates.AddImageDelegate
import kotlinx.android.synthetic.main.view_holder_add_image_item.view.*

class AddImageViewHolder(itemView: View, private val mDelegate: AddImageDelegate) :
    BaseViewHolder(itemView) {

    val addImage: ShapeableImageView = itemView.addImage

    init {
        itemView.addImage.setOnClickListener {
            mDelegate.onTapFileUpload()
        }
    }

    fun bindData(imageList: String) {
        Glide.with(itemView.context)
            .load(imageList)
            .into(itemView.addImage)
    }

}