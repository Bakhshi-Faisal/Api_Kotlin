package com.example.myapplication3.dogapi.remote

import com.example.myapplication3.dogapi.model.DogImageRetrofit
import retrofit2.http.GET
import kotlin.random.Random



interface DogImageQuoteEndpoint {
    @GET("Any")
    suspend fun getRandomQuote() : DogImageRetrofit
}