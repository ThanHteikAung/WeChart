package com.tha.wechart.fragments

import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.tha.wechart.R
import com.tha.wechart.data.vos.UserVO
import com.tha.wechart.mvp.presenters.MePresenter
import com.tha.wechart.mvp.presenters.MePresenterImpl
import com.tha.wechart.mvp.views.MeView
import kotlinx.android.synthetic.main.fragment_me.*

class MeFragment : Fragment(), MeView {

    private lateinit var mPresenter: MePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_me, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        mPresenter.getUserRegister()
        setUpOnClickListener()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[MePresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpOnClickListener() {
        ivQRCode.setOnClickListener {
            popUpView.visibility = View.VISIBLE
            ivPopUpQRCode.visibility = View.VISIBLE
        }

        popUpView.setOnClickListener {
            popUpView.visibility = View.GONE
            ivPopUpQRCode.visibility = View.GONE
        }

    }

    override fun bindData(register: UserVO) {
        tvName.text = register.name
        tvPhoneNumber.text = register.phNo
        tvDOB.text = register.dateOfBirth
        tvGender.text = register.gender

        register.phNo?.let { phNo ->
            val bitmap = generateQRCode(phNo)
            ivQRCode.setImageBitmap(bitmap)
            ivPopUpQRCode.setImageBitmap(bitmap)
        }

    }

    private fun generateQRCode(text: String): Bitmap {
        val width = 150
        val height = 150
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val codeWriter = MultiFormatWriter()
        try {
            val bitMatrix =
                codeWriter.encode(text, BarcodeFormat.QR_CODE, width, height)
            for (x in 0 until width) {
                for (y in 0 until height) {
                    val color = if (bitMatrix[x, y]) Color.BLACK else Color.WHITE
                    bitmap.setPixel(x, y, color)
                }
            }
        } catch (e: WriterException) {

            Log.d(TAG, "generateQRCode: ${e.message}")

        }
        return bitmap
    }


}