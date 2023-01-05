package com.tha.wechart.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.tha.wechart.R
import com.tha.wechart.data.vos.UserVO
import com.tha.wechart.view.viewholders.MomentViewHolder

class MomentAdapter : BaseRecyclerAdapter<MomentViewHolder>() {

    private lateinit var mMomentImageAdapter: MomentImageAdapter
    private var mUserMomentList: List<UserVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_moment_item, parent, false)
        return MomentViewHolder(view)
    }

    override fun onBindViewHolder(holder: MomentViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        //setUp Moment Image Recycler
        mMomentImageAdapter = MomentImageAdapter()
        val momentImageManager = GridLayoutManager(
            holder.mMomentImageRecyclerView.context,
            2,
            GridLayoutManager.VERTICAL,
            false
        )

        holder.mMomentImageRecyclerView.apply {
            adapter = mMomentImageAdapter
            layoutManager = momentImageManager
        }
        holder.bindData(mUserMomentList[position])
        mUserMomentList[position].imageUrl?.let { mMomentImageAdapter.setNewData(it) }
    }

    override fun getItemCount(): Int {
        return mUserMomentList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(userMomentList: List<UserVO>) {
        mUserMomentList = userMomentList
        notifyDataSetChanged()
    }
}