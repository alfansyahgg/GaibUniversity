package com.example.gaibuniversity.Interface.Example

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ExampleObject {
    val BASE_URL: String = "https://jsonplaceholder.typicode.com/"
    val exampleInterface: ExampleInterface
    get() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create( ExampleInterface::class.java )
    }

}