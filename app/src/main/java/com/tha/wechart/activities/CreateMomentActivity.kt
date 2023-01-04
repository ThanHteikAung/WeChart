package com.tha.wechart.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tha.wechart.R
import com.tha.wechart.adapters.AddImageAdapter
import com.tha.wechart.mvp.presenters.CreateMomentPresenter
import com.tha.wechart.mvp.presenters.CreateMomentPresenterImpl
import com.tha.wechart.mvp.views.CreateMomentView
import kotlinx.android.synthetic.main.activity_create_moment.*
import java.io.IOException
import java.sql.Timestamp
import java.util.*

class CreateMomentActivity : AppCompatActivity(), CreateMomentView {

    private lateinit var mAddImageAdapter: AddImageAdapter
    private lateinit var mPresenter: CreateMomentPresenter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CreateMomentActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_moment)
        setUpPresenter()
        setUpAddImageRecycler()
        setUpListener()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[CreateMomentPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    //setUp AddImage Recycler
    private fun setUpAddImageRecycler() {
        mAddImageAdapter = AddImageAdapter(mPresenter)
        rvAddImage.adapter = mAddImageAdapter
        rvAddImage.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setUpListener() {
        btnCreateMoment.setOnClickListener {
            val stamp = Timestamp(System.currentTimeMillis())
            val date = Date(stamp.time).toString()
            val textContext = createText.text.toString()
            mPresenter.onTapCreate(date, textContext)
        }
    }

    override fun navigateToMoment() {
        finish()
    }

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                if (data?.clipData != null) {
                    data.clipData?.let {
                        val dataCount: Int = it.itemCount
                        for (data in 0 until dataCount) {
                            val filePath = it.getItemAt(data).uri
                            changeUriToBitmap(filePath)
                        }
                    }
                } else {
                    if (data != null || data?.data != null) {
                        val filePath = data.data
                        changeUriToBitmap(filePath)
                    }
                }
            }
        }

    private fun changeUriToBitmap(filePath: Uri?) {
        try {
            filePath?.let {
                if (Build.VERSION.SDK_INT >= 29) {
                    val source: ImageDecoder.Source =
                        ImageDecoder.createSource(this.contentResolver, it)

                    val bitmap = ImageDecoder.decodeBitmap(source)
                    mPresenter.onPhotoTaken(bitmap)
                } else {
                    val bitmap = MediaStore.Images.Media.getBitmap(
                        this.contentResolver,
                        filePath
                    )
                    mPresenter.onPhotoTaken(bitmap)
                }
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.action = Intent.ACTION_GET_CONTENT
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        intent.type = "image/*"
        resultLauncher.launch(Intent.createChooser(intent, "Select Picture"))
    }

    override fun showSelectedImage(imageUriList: ArrayList<String>) {
        mAddImageAdapter.setNewData(imageUriList)
    }
}