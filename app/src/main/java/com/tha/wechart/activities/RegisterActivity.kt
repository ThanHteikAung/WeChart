package com.tha.wechart.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.tha.wechart.R
import java.util.*

class RegisterActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setUpSpinner()
    }


    private fun setUpSpinner() {
        val spinnerYear: Spinner = findViewById(R.id.spinnerYear)
        val spinnerMonth: Spinner = findViewById(R.id.spinnerMonth)
        val years = resources.getStringArray(R.array.years)
        var monthList = ArrayList<String>()

        //set Month
        for (month in 1..12) {
            monthList.add(month.toString())
        }
        ArrayAdapter(this, android.R.layout.simple_spinner_item, monthList)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerMonth.adapter = adapter
                spinnerMonth.onItemSelectedListener = object : OnItemSelectedListener {

                    override fun onItemSelected(
                        p0: AdapterView<*>?,
                        p1: View?,
                        position: Int,
                        p3: Long
                    ) {
                        val year = spinnerYear.selectedItem.toString()
                        val selectedMonth = monthList[position]
                        calDays(year.toInt(), selectedMonth)
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {

                    }

                }
            }

        //set year
        ArrayAdapter.createFromResource(
            this,
            R.array.years,
            android.R.layout.simple_spinner_item,

            ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerYear.adapter = adapter
            spinnerYear.onItemSelectedListener = object : OnItemSelectedListener {

                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    p1: View?,
                    position: Int,
                    p3: Long
                ) {
                    val year = years[position].toInt()
                    val selectedMonth = spinnerMonth.selectedItem.toString()
                    calDays(year, selectedMonth)

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
        }
    }

    private fun calDays(year: Int, selectedMonth: String) {
        val spinnerDay: Spinner = findViewById(R.id.spinnerDay)
        var mDays: Int = 0
        var daysList = ArrayList<Int>()
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, selectedMonth.toInt() - 1)
        //mDays = YearMonth.of(year, selectedMonth.toInt()).lengthOfMonth()
        mDays = calendar.getActualMaximum(Calendar.DATE)
        println("********Test*******")
        println(mDays)

        //Set days
        for (day in 1..mDays) {
            daysList.add(day)
        }
        ArrayAdapter(this, android.R.layout.simple_spinner_item, daysList).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerDay.adapter = adapter
        }
    }


}