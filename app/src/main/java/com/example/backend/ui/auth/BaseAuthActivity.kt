package com.example.backend.ui.auth

import androidx.appcompat.app.AppCompatActivity

abstract class BaseAuthActivity: AppCompatActivity(){
    abstract fun getResId(): Int
}