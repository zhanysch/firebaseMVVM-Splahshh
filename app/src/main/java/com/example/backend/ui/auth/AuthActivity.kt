package com.example.backend.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.backend.R
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_auth.*
import java.util.concurrent.TimeUnit

class AuthActivity : BaseAuthActivity() {

    private val viewModel by viewModels<AuthViewModel>()


    override fun getResId()= R.layout.activity_auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        setupListeners()
    }

    private fun setupListeners() {
        btnEnter.setOnClickListener {
            verifyPhone(etInputNumber.text.toString())
        }
        btnSentCode.setOnClickListener {
            val credential = PhoneAuthProvider.getCredential(
                    storedVerificationId!!, etInputCode.text.toString()
            )
            signInWithPhoneAuthCredential(credential)
        }
    }



}