package com.example.backend.architect.repository


import androidx.lifecycle.MutableLiveData
import com.example.backend.architect.api.FirebaseApi
import com.example.backend.model.NewsItem

interface FirebaseRepository {
    fun loadData() : MutableLiveData<ArrayList<NewsItem>>
}

class FirebaseRepositoryImpl(private val network : FirebaseApi): FirebaseRepository {

    //(private val network : FirebaseApi)
    // конструктор для того чтоб связать из class Modules , FirebaseRepos c FirebaseApi


    override fun loadData() : MutableLiveData<ArrayList<NewsItem>> {
        val data = network.loadData()

        /*save in room
        save in room
         save in sharedpreference and others bla bla bla
       */
        return data
    }
}