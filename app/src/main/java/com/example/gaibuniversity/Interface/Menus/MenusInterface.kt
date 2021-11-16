package com.example.gaibuniversity.Interface.Menus

import com.example.gaibuniversity.dataModel.HomeMenuModel
import retrofit2.Call
import retrofit2.http.GET

interface MenusInterface {
    @GET("menu")
    fun getMenus(): Call<ArrayList<HomeMenuModel>>

}