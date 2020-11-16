package com.example.backend.ui.splah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.backend.R
import com.example.backend.ui.auth.AuthActivity
import com.example.backend.ui.main.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {
    private val viewModel by viewModel<SplashViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)




        val mUser = FirebaseAuth.getInstance().currentUser
        if (mUser== null) {
            startActivity(Intent(this, AuthActivity:: class.java))
        }
        else{
            loadToken(mUser)
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
                }
    }

}