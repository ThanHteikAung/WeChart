package network

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object CloudFireStoreFirebaseApiImpl : FirebaseApi {

    val db = Firebase.firestore

    override fun addRegister(
        phNo: String,
        name: String,
        dateOfBirth: String,
        gender: String,
        pass: String
    ) {
        println("******Testing Register *****")
        println("$phNo,$name,$dateOfBirth,$gender,$pass")
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
}