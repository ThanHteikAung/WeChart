package com.tha.wechart.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_holder_moment_image_item.view.*
import kotlinx.android.synthetic.main.view_holder_moment_item.view.*
import java.util.ArrayList

class MomentImageViewHolder(itemView: View) : BaseViewHolder(itemView) {

    fun bindData(userMomentImage: String){
        Glide.with(itemView.context)
            .load(userMomentImage)
            .into(itemView.imgMoment)

    }

}