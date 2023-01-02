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
                        if (size>0){
                            onSuccess()
                        }else{
                            onFailure("Wrong Phone or Password")
                        }
                    }
                    /*val result = value?.data
                    val register = RegisterVO()
                    register.phNo = result?.get("phNo") as String
                    register.pass = result?.get("pass") as String
                    onSuccess(register)*/
                    /*println(value?.documents?.size)
                    onSuccess()*/
                }
            }
    }
}