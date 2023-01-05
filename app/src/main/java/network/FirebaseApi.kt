package network

import android.graphics.Bitmap
import com.tha.wechart.data.vos.UserVO

interface FirebaseApi {

    fun addRegister(phNo: String, name: String, dateOfBirth: String, gender: String, pass: String)
    fun getRegister(
        phNo: String,
        pass: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun uploadImageAndEditGrocery(
        image: Bitmap,
        onSuccess: (ArrayList<String>) -> Unit,
    )

    fun addMoment(
        postTime: Long,
        textContact: String,
        image: ArrayList<String>
    )

    fun getUserData(
        phNo: String,
        onSuccess: (userDataList: List<UserVO>) -> Unit,
        onFailure: (String) -> Unit
    )

}