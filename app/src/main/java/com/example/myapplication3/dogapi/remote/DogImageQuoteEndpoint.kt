package com.example.myapplication3.DogImage.remote

import com.example.myapplication3.dogapi.model.DogImageRetrofit
import retrofit2.http.GET
import kotlin.random.Random



interface DogImageQuoteEndpoint {
    @GET("random")
    suspend fun getRandomQuote() : DogImageRetrofit
}