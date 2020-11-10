package com.example.backend.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.backend.R
import com.example.backend.model.NewsItem
import com.example.backend.model.RvAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adapter = RvAdapter()

    val data = arrayListOf<NewsItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.adapter = adapter

        val database = Firebase.database
        val ref = database.getReferenceFromUrl("https://first-backend-firebase-2fbe5.firebaseio.com/")

        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (postSnapshot in snapshot.children){
                    val point = postSnapshot.getValue(NewsItem:: class.java)
                    point?.let { data.add(it) }
                    
                    //point?.let { adapter.submitList(data.add()) }
                }
                //tvcount.text = data.size.toString()
                adapter.submitList(data)
            }
            override fun onCancelled(error: DatabaseError) {
                Log.d("gdgsdg", "gsgsdgs")
            }
        })
    }
}