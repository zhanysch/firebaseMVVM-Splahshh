package com.example.backend.repository


import androidx.lifecycle.MutableLiveData
import com.example.backend.api.FirebaseApiImpl
import com.example.backend.model.NewsItem

interface FirebaseRepository {
    fun loadData() : MutableLiveData<ArrayList<NewsItem>>
}

class FirebaseRepositoryImpl: FirebaseRepository {
    private val network = FirebaseApiImpl()

    override fun loadData() : MutableLiveData<ArrayList<NewsItem>> {
        val data = network.loadData()

        /*save in room
        save in room
         save in sharedpreference and others bla bla bla
       */
        return data
    }
}