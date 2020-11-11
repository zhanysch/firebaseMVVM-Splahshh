package com.example.backend.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.backend.R
import com.example.backend.model.ItemLIstener
import com.example.backend.model.NewsItem
import com.example.backend.model.RvAdapter
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity(),ItemLIstener {

    private val viewModel by viewModels<MainViewModel>()
    private val adapter = RvAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.adapter = adapter
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.showItems().observe(this, Observer {
            adapter.submitList(it)
            //textview// tvcount.text = it.size.toString
        })
    }

    override fun itemsClick(check: NewsItem) {
        val intent = Intent(this, DetailActivity:: class.java)
        intent.putExtra("data",check)
        startActivity(intent)
    }
}

