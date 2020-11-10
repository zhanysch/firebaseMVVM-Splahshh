package com.example.backend.ui.main
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.backend.model.NewsItem
import com.example.backend.repository.FirebaseRepositoryImpl



class MainViewModel: ViewModel() {

    private val repository = FirebaseRepositoryImpl()

    fun showItems(): MutableLiveData<ArrayList<NewsItem>> {
         return repository.loadData()
    }
}