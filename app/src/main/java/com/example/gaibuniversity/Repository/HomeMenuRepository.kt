package com.example.gaibuniversity.Repository

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.airbnb.lottie.LottieAnimationView
import com.example.gaibuniversity.Adapter.HomeAdapter
import com.example.gaibuniversity.Interface.Menus.MenusObject
import com.example.gaibuniversity.R
import com.example.gaibuniversity.dataModel.HomeMenuModel
import com.example.gaibuniversity.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeMenuRepository {

    lateinit var homeAdapter: HomeAdapter
    private var homeList = ArrayList<HomeMenuModel>()
    private val mutableLiveData = MutableLiveData<HomeMenuModel>()

    fun getMutableLiveData(binding: FragmentHomeBinding): MutableLiveData<HomeMenuModel> {
        MenusObject.menusInterface.getMenus()
            .enqueue(object: Callback<HomeMenuModel>{
                override fun onResponse(
                    call: Call<HomeMenuModel>,
                    response: Response<HomeMenuModel>
                ) {
                    if(response.isSuccessful){
                        Log.d("Result", ""+response.body())
                        val result = response.body()
                        if(result != null){
//                            homeList = result
                            mutableLiveData.value = result!!
                            binding.rvMain.visibility = View.VISIBLE
                        }
                        if(binding.lavLoading.visibility == View.VISIBLE){
                            binding.lavLoading.visibility = View.GONE
                        }
                        binding.srlDashboard.isRefreshing = false
                    }
                }

                override fun onFailure(call: Call<HomeMenuModel>, t: Throwable) {
                    binding.srlDashboard.isRefreshing = false
                    if(binding.lavLoading.visibility == View.VISIBLE){
                        binding.lavLoading.visibility = View.GONE
                    }
                }
            })

        return mutableLiveData
    }


}