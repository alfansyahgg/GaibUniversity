package com.example.gaibuniversity.Interface.Example

import com.example.gaibuniversity.dataModel.ExampleModel
import retrofit2.Call
import retrofit2.http.GET

interface ExampleInterface {
    @GET("posts")
    fun getPosts(): Call<List<ExampleModel>>
}