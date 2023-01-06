package com.tha.wechart.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tha.wechart.R

class ChartRoomActivity : AppCompatActivity() {

    companion object{
        fun newIntent(context: Context): Intent{
            return Intent(context,ChartRoomActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart_room)
    }
}