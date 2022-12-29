package com.tha.wechart.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tha.wechart.R
import com.tha.wechart.adapters.AddImageAdapter
import kotlinx.android.synthetic.main.activity_create_moment.*

class CreateMomentActivity : AppCompatActivity() {

    private lateinit var mAddImageAdapter: AddImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_moment)
        setUpAddImageRecycler()
    }

    //setUp AddImage Recycler
    private fun setUpAddImageRecycler() {
        mAddImageAdapter = AddImageAdapter()
        rvAddImage.adapter = mAddImageAdapter
        rvAddImage.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}