package network

import android.graphics.Bitmap
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream
import java.util.*

object CloudFireStoreFirebaseApiImpl : FirebaseApi {

    val db = Firebase.firestore
    private val storage = FirebaseStorage.getInstance()
    private val imageUrlList = arrayListOf<String>()

    override fun addRegister(
        phNo: String,
        name: String,
        dateOfBirth: String,
        gender: String,
        pass: String
    ) {
        val registerMap = hashMapOf(
            "phNo" to phNo,
            "name" to name,
            "dateOfBirth" to dateOfBirth,
            "gender" to gender,
            "pass" to pass
        )
        db.collection("registers")
            .document(phNo)
            .set(registerMap)
            .addOnSuccessListener { Log.d("Success", "Successfully added register") }
            .addOnFailureListener { Log.d("Failure", "Failed to add register") }
    }

    override fun addMoment(postTime: String, textContact: String, image: ArrayList<String>) {
        val momentMap = hashMapOf(
            "postTime" to postTime,
            "textContact" to textContact,
            "image" to image
        )
        db.collection("registers").document("09420082322").collection("moments")
            .document(postTime)
            .set(momentMap)
            .addOnSuccessListener { Log.d("Success", "Successfully added moments") }
            .addOnFailureListener { Log.d("Failure", "Failed to add register") }
    }

    override fun getRegister(
        phNo: String,
        pass: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("registers").whereEqualTo("phNo", phNo).whereEqualTo("pass", pass)
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check connection")
                } ?: run {
                    value?.documents?.size?.let { size ->
                        if (size > 0) {
                            onSuccess()
                        } else {
                            onFailure("Wrong Phone or Password")
                        }
                    }
                }
            }
    }

    override fun uploadImageAndEditGrocery(
        image: Bitmap,
        onSuccess: (ArrayList<String>) -> Unit
    ) {
        val baos = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos)

        val data = baos.toByteArray()
        val imageRef = storage.reference.child("images/${UUID.randomUUID()}")
        imageRef.putBytes(data)
            .addOnFailureListener { }
            .addOnSuccessListener { }
            .continueWithTask {
                return@continueWithTask imageRef.downloadUrl
            }.addOnCompleteListener { task ->
                val imageUrl = task.result.toString()
                imageUrlList.add(imageUrl)
                onSuccess(imageUrlList)
                println("success -> $imageUrl")
                println("End to End -> ${imageUrlList.toString()}")
            }
        imageUrlList.removeAll(imageUrlList.toSet())
    }

}