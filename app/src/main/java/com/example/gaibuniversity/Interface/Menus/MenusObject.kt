package com.example.gaibuniversity.Interface.Menus

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MenusObject {
//    val BASE_URL: String = "http://192.168.42.150/slim-kampus/"

    val BASE_URL: String = "http://192.168.42.150:8000/api/"
    val menusInterface: MenusInterface
    get(){
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request()
                val httpRequest = request.newBuilder()
                    .addHeader("Authorization",
                        "Bearer 2|9QADWOCYVkQ5yETPsov9KbPVfy7KvFZg2A81xDen")
                    .build()
                val response = chain.proceed(httpRequest)
                response
            }
//            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create( MenusInterface::class.java )
    }

}