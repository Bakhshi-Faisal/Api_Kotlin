package com.example.myapplication3.architecture

import com.example.myapplication3.DogImage.remote.DogImageQuoteEndpoint
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/breeds/image/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
        .build()




    fun getdogImageQuote(): DogImageQuoteEndpoint = retrofit.create(DogImageQuoteEndpoint::class.java)
}
