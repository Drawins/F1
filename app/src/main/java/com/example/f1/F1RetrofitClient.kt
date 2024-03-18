package com.example.f1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object F1RetrofitClient {
    private const val BASE_URL = "https://ergast.com/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getService(): F1ApiService {
        return retrofit.create(F1ApiService::class.java)
    }
}
