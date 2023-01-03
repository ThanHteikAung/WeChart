package com.tha.wechart.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.tha.wechart.R
import com.tha.wechart.mvp.presenters.LoginPresenter
import com.tha.wechart.mvp.presenters.LoginPresenterImpl
import com.tha.wechart.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var mPresenter: LoginPresenter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setUpPresenter()
        setUpOnClickListener()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[LoginPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpOnClickListener() {
        btnBack.setOnClickListener {
            mPresenter.onTapBackToMain()
        }

        btnLogin.setOnClickListener {
            val phNo = edtPhoneNumber.text.toString()
            val pass = edtPassword.text.toString()
            if (phNo.isEmpty()) {
                txtInputPhNo.helperText = "*Require"
            } else if (pass.isEmpty()) {
                txtInputPhNo.helperText = ""
                txtInputPass.helperText = "*Require"
            } else {
                txtInputPass.helperText = ""
                mPresenter.onTapLogin(phNo, pass)
            }
        }

    }

    override fun navigateToMainScreen() {
        startActivity(MainActivity.newIntent(this))
    }

    override fun navigateToMomentScreen() {
        startActivity(MainFragmentActivity.newIntent(this))
    }

    override fun showError(error: String) {
        Snackbar.make(window.decorView, error, Snackbar.LENGTH_LONG).show()
    }
}