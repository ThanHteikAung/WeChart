package network

import android.graphics.Bitmap

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
        postTime: String,
        textContact: String,
        image: ArrayList<String>
    )

}