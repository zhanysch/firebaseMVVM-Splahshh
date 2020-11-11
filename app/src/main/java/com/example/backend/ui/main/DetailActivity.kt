package com.example.backend.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.backend.R
import com.example.backend.model.NewsItem
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val item = intent.getParcelableExtra<NewsItem>("data")
        textOne.text = item?.desc.toString()
        product.text = item?.title.toString()
    }
}