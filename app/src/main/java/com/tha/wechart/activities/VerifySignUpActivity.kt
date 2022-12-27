package com.tha.wechart.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.tha.wechart.R
import com.tha.wechart.mvp.presenters.VerifySignUpPresenter
import com.tha.wechart.mvp.presenters.VerifySignUpPresenterImpl
import com.tha.wechart.mvp.views.VerifySignUpView

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
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[VerifySignUpPresenterImpl::class.java]
        mPresenter.initial(this)
    }

}