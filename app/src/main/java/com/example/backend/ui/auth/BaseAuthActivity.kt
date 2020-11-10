package com.example.backend.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseAuthActivity: AppCompatActivity(){
    abstract fun getResId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getResId())
    }
}