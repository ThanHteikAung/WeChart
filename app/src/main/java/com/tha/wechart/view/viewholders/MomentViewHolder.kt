package com.tha.wechart.view.viewholders

import android.text.format.DateUtils
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tha.wechart.data.vos.UserVO
import kotlinx.android.synthetic.main.view_holder_moment_item.view.*

class MomentViewHolder(itemView: View) : BaseViewHolder(itemView) {

    val mMomentImageRecyclerView: RecyclerView = itemView.rvMomentImage

    fun bindData(user: UserVO) {
        itemView.txtProfileName.text = user.name
        itemView.txtContact.text = user.textContext
        user.postTime?.let { time ->
            val now = System.currentTimeMillis()
            itemView.txtTimeAgo.text =
                DateUtils.getRelativeTimeSpanString(time, now, DateUtils.MINUTE_IN_MILLIS)
        }
    }
}