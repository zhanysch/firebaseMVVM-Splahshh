package com.example.backend.ui.splah

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.backend.ui.auth.AuthActivity
import com.example.backend.ui.main.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SplashViewModel:ViewModel() {

  /*  val user = MutableLiveData<Boolean>()

    fun verfy(){
        val mUser = FirebaseAuth.getInstance().currentUser
        if (mUser== null) {
            startActivity(Intent(this, AuthActivity:: class.java))
        }
        else{
            loadToken(mUser)
        }
        return user.postValue(user)
    }
}
    private fun loadToken(mUser: FirebaseUser) {
        mUser.getIdToken(true)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val idToken = task.result!!.token
                        startActivity(Intent(this, MainActivity:: class.java))
                        // Send token to your backend via HTTPS
                        // ...
                    } else {
                        startActivity(Intent(this, AuthActivity:: class.java))
                    }
                }*/

}