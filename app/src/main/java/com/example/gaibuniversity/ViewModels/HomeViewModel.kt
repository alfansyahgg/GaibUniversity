package com.example.gaibuniversity.ViewModels

import android.app.Application
import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.airbnb.lottie.LottieAnimationView
import com.example.gaibuniversity.Repository.HomeMenuRepository
import com.example.gaibuniversity.dataModel.HomeMenuModel
import com.example.gaibuniversity.databinding.FragmentHomeBinding

class HomeViewModel(application: Application): AndroidViewModel(application) {
    private lateinit var homeMenuRepository: HomeMenuRepository

    fun getAllHomeMenus(binding: FragmentHomeBinding): LiveData<ArrayList<HomeMenuModel>>{
        homeMenuRepository = HomeMenuRepository()
        return homeMenuRepository.getMutableLiveData(binding)
    }
}