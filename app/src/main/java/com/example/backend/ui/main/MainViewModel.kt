package com.example.backend.ui.main
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.backend.model.NewsItem
import com.example.backend.architect.repository.FirebaseRepository


class MainViewModel(private val repository : FirebaseRepository): ViewModel() {


    fun showItems(): MutableLiveData<ArrayList<NewsItem>> {
         return repository.loadData()
    }
}