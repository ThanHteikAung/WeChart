package com.tha.wechart.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.tha.wechart.R
import com.tha.wechart.mvp.presenters.VerifySignUpPresenter
import com.tha.wechart.mvp.presenters.VerifySignUpPresenterImpl
import com.tha.wechart.mvp.views.VerifySignUpView
import kotlinx.android.synthetic.main.activity_verify_sign_up.*

class VerifySignUpActivity : AppCompatActivity(), VerifySignUpView {

    private lateinit var mPresenter: VerifySignUpPresenter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, VerifySignUpActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_sign_up)
        setUpPresenter()
        setUpListener()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[VerifySignUpPresenterImpl::class.java]
        mPresenter.initial(this)
    }

    private fun setUpListener() {

        btnVerify.setOnClickListener {
            mPresenter.onTapVerifySignUpRegister()
        }

        btnGetOtp.setOnClickListener {
            if (edtPhoneNumber.text.isNotEmpty()) {
                mPresenter.onTapGetOTP()
            } else {
                Snackbar.make(
                    window.decorView,
                    "Please insert phone number correctly",
                    Snackbar.LENGTH_LONG
                ).show()
            }

        }

        // first EditText is filled by 1 number then, focus should goes to next
        txtFirstOtp.addTextChangedListener {
            if (it?.length == 1) {
                txtSecondOtp.requestFocus()
            }
        }
        txtSecondOtp.addTextChangedListener {
            if (it?.length == 1) {
                txtThirdOtp.requestFocus()
            }
        }
        txtThirdOtp.addTextChangedListener {
            if (it?.length == 1) {
                txtFouthOtp.requestFocus()
            }
        }

        //Delete current editText and after cursor focus move to previous editText
        txtSecondOtp.setOnKeyListener(otpKeyListener(txtSecondOtp, txtFirstOtp))
        txtThirdOtp.setOnKeyListener(otpKeyListener(txtThirdOtp, txtSecondOtp))
        txtFouthOtp.setOnKeyListener(otpKeyListener(txtFouthOtp, txtThirdOtp))
    }

    //Delete  previous EditText(OTP)
    private fun otpKeyListener(
        currentEditText: EditText,
        previousEditText: EditText
    ): View.OnKeyListener {
        return View.OnKeyListener { view, keyCode, event ->
            if (event!!.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && currentEditText.id != R.id.txtFirstOtp && currentEditText.text.isEmpty()) {
                previousEditText.text = null
                previousEditText.requestFocus()
                return@OnKeyListener true
            }
            return@OnKeyListener false
        }
    }


    override fun navigateToVerifyRegisterSignUp() {
        val strFirstOtp = txtFirstOtp.text.toString()
        val strSndOtp = txtSecondOtp.text.toString()
        val strThirdOtp = txtThirdOtp.text.toString()
        val strFourthOtp = txtFouthOtp.text.toString()
        val checkOtp = "$strFirstOtp$strSndOtp$strThirdOtp$strFourthOtp"

        if (checkOtp == "0000") {
            startActivity(RegisterActivity.newIntent(this, edtPhoneNumber.text.toString()))
        } else if (checkOtp == "") {
            Snackbar.make(window.decorView, "Please fill and request OTP", Snackbar.LENGTH_LONG)
                .show()
        }

    }

    override fun showNotificationOTP() {
        Snackbar.make(window.decorView, "One Time Password (OTP) 0000", Snackbar.LENGTH_LONG).show()
    }

}