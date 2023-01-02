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
import androidx.lifecycle.ViewModelProvider
import com.tha.wechart.R
import com.tha.wechart.mvp.presenters.RegisterPresenter
import com.tha.wechart.mvp.presenters.RegisterPresenterImpl
import com.tha.wechart.mvp.views.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import java.util.*

class RegisterActivity : AppCompatActivity(), RegisterView {

    private lateinit var mPresenter: RegisterPresenter

    companion object {
        private const val EXTRA_PHONE_NUMBER = "EXTRA_PHONE_NUMBER"
        fun newIntent(context: Context, phNo: String): Intent {
            println("newIntent() -> $phNo")
            return Intent(context, RegisterActivity::class.java).putExtra(
                EXTRA_PHONE_NUMBER, phNo
            )
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setUpPresenter()
        setUpSpinner()
        setUpListener()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[RegisterPresenterImpl::class.java]
        mPresenter.initial(this)
    }

    private fun setUpSpinner() {
        val spinnerYear: Spinner = findViewById(R.id.spinnerYear)
        val spinnerMonth: Spinner = findViewById(R.id.spinnerMonth)
        val months = resources.getStringArray(R.array.months)
        var yearList = ArrayList<String>()

        //set Month
        ArrayAdapter.createFromResource(this, R.array.months, android.R.layout.simple_spinner_item)
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
                        val selectedMonth = months[position]
                        calDays(year, selectedMonth)
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {

                    }

                }
            }

        //set year
        val thisYear = Calendar.getInstance().get(Calendar.YEAR)
        yearList.add("Year")
        for (year in 1950..thisYear) {
            yearList.add(year.toString())
        }
        ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            yearList

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
                    val year = yearList[position]
                    val selectedMonth = spinnerMonth.selectedItem.toString()
                    calDays(year, selectedMonth)
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
        }
    }

    private fun calDays(year: String, selectedMonth: String) {
        val spinnerDay: Spinner = findViewById(R.id.spinnerDay)
        var mDays: Int = 0
        var daysList = ArrayList<String>()
        val calendar = Calendar.getInstance()
        val strMonthList = mapOf(
            "Jan" to 1,
            "Feb" to 2,
            "Mar" to 3,
            "Apr" to 4,
            "May" to 5,
            "Jun" to 6,
            "Jul" to 7,
            "Aug" to 8,
            "Sept" to 9,
            "Oct" to 10,
            "Nov" to 11,
            "Dec" to 12
        )
        daysList.add("Day")
        if (year != "Year" && selectedMonth != "Month") {
            val intMonth = strMonthList[selectedMonth] ?: 0
            calendar.set(Calendar.YEAR, year.toInt())
            calendar.set(Calendar.MONTH, intMonth - 1)
            mDays = calendar.getActualMaximum(Calendar.DATE)

            //Set days
            for (day in 1..mDays) {
                daysList.add(day.toString())
            }
        }
        ArrayAdapter(this, android.R.layout.simple_spinner_item, daysList).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerDay.adapter = adapter
        }

    }

    private fun setUpListener() {
        btnRegisterSignUp.setOnClickListener {
            val day = spinnerDay.selectedItem.toString()
            val month = spinnerMonth.selectedItem.toString()
            val year = spinnerYear.selectedItem.toString()
            val strName = edtPhoneNumber.text.toString()
            val dateOfBirth = "$day/$month/$year"
            val mPhNo = intent.getStringExtra(EXTRA_PHONE_NUMBER).toString()
            println("Get PhoneNumber -> $mPhNo")
            println("***Test Register***")
            val genderId = rbgGender.checkedRadioButtonId
            val genderString = resources.getResourceEntryName(genderId)
            println(genderString)
            if (strName.isEmpty()) {
                txtInputName.helperText = "*Require"
            } else if (year == "Year") {
                tilDateOfBth.helperText = "*Require input year"
            } else if (month == "Month") {
                tilDateOfBth.helperText = "*Require input month"
            } else if (day == "Day") {
                tilDateOfBth.helperText = "*Require input day"
            } else {
                txtInputName.helperText = ""
                tilDateOfBth.helperText = ""
                mPresenter.onTapVerifyRegister(
                    mPhNo,
                    edtPhoneNumber.text.toString(),
                    dateOfBirth,
                    genderString,
                    edtPassword.text.toString()
                )
            }
        }
    }

    override fun addRegister() {
        startActivity(LoginActivity.newIntent(this))
    }

}