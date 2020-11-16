package com.example.backend.architect.di

import com.example.backend.architect.api.FirebaseApi
import com.example.backend.architect.api.FirebaseApiImpl
import com.example.backend.architect.repository.FirebaseRepository
import com.example.backend.architect.repository.FirebaseRepositoryImpl
import com.example.backend.ui.main.MainViewModel
import com.example.backend.ui.splah.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

// этот класс для того чтоб свзяать мжеду собой vviewmodel , FirebaseRepository, Firebase apii по MVVM

val viewModelModule : Module = module{
    viewModel { MainViewModel(get()) } //get() получает запрос из FirebaseRepository impk
    viewModel { SplashViewModel() }
}
val repositoryModule : Module = module{
    single <FirebaseRepository> { FirebaseRepositoryImpl(get())}  //get() получает запрос из FirebaseApiiml
}
val apiModule : Module = module{
    single <FirebaseApi> { FirebaseApiImpl()}
}