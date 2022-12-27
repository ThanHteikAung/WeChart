package com.tha.wechart.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.tha.wechart.R
import com.tha.wechart.mvp.presenters.MainPresenter
import com.tha.wechart.mvp.presenters.MainPresenterImpl
import com.tha.wechart.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mPresenter: MainPresenter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpPresenter()
        setUpOnClickListener()

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[MainPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpOnClickListener() {
        btnFstLogin.setOnClickListener {
            mPresenter.onTapLogin()
        }

        btnFstSignUp.setOnClickListener {
            mPresenter.onTapSignUp()
        }
    }

    override fun navigateToLogin() {
        startActivity(LoginActivity.newIntent(this))
    }

    override fun navigateToVerifySignUpOTP() {
        startActivity(VerifySignUpActivity.newIntent(this))
    }


}