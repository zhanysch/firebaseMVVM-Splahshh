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
        setupViewModel()
        viewModel.auth()


    }

    private fun setupViewModel() {
        viewModel.isAuthUser.observe(this, {
            if (it) openMain()
            else openAuth()
        })
    }

    private fun openMain(){
        startActivity(Intent(this,MainActivity::class.java))
    }
    private fun openAuth(){
        startActivity(Intent(this,AuthActivity::class.java))
    }




}