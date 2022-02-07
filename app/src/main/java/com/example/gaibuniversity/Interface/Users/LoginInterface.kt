package com.example.gaibuniversity.Interface.Users

import retrofit2.http.POST

interface LoginInterface {

    @POST
    fun login()
}