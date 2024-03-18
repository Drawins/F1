package com.example.f1

import retrofit2.Call
import retrofit2.http.GET

interface F1ApiService {
    @GET("f1/2024")
    fun getRaces(): Call<RaceTable>
}



