package com.example.gaibuniversity.ViewModels

import android.app.Application
import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.airbnb.lottie.LottieAnimationView
import com.example.gaibuniversity.Repository.HomeMenuRepository
import com.example.gaibuniversity.dataModel.HomeMenuModel
import com.example.gaibuniversity.databinding.FragmentHomeBinding
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel(application: Application): AndroidViewModel(application) {
    private lateinit var homeMenuRepository: HomeMenuRepository
    lateinit var data: LiveData<HomeMenuModel>

    fun getAllHomeMenus(binding: FragmentHomeBinding): LiveData<HomeMenuModel>{
        viewModelScope.launch {
            data = HomeMenuRepository().getMutableLiveData(binding)
        }
        return data
    }
}