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

    val isAuthUser = MutableLiveData<Boolean>()
   fun auth(){
        val mUser = FirebaseAuth.getInstance().currentUser
        if (mUser== null) {
            isAuthUser.postValue(false)
        }
        else{
            loadToken(mUser)
        }
    }

    private fun loadToken(mUser: FirebaseUser) {
        mUser.getIdToken(true)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        isAuthUser.postValue(true)
                    } else {
                        isAuthUser.postValue(false)
                    }
                }
    }

}