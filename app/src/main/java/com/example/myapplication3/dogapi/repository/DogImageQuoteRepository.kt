package com.example.myapplication3.dogapi.repository

import androidx.lifecycle.LiveData
import com.example.myapplication3.architecture.CustomApplication
import com.example.myapplication3.architecture.RetrofitBuilder
import com.example.myapplication3.dogapi.model.DogImageRetrofit
import com.example.myapplication3.dogapi.model.DogImageRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogImageQuoteRepository {

    private val mDogImageDao = CustomApplication.instance.mApplicationDatabase.DogImageDao()

    fun selectAllDogImageQuote(): LiveData<List<DogImageRoom>> {
        return mDogImageDao.selectAll()
    }


    private suspend fun insertDogImageQuote(DogImageQuote: DogImageRoom) =
        withContext(Dispatchers.IO) {
            mDogImageDao.insert(DogImageQuote)
        }


    suspend fun deleteAllDogImageQuote() = withContext(Dispatchers.IO) {
        mDogImageDao.deleteAll()
    }


    suspend fun fetchData() {
        insertDogImageQuote(RetrofitBuilder.getdogImageQuote().getRandomQuote().toRoom())
    }

    private fun DogImageRetrofit.toRoom(): DogImageRoom {
        return DogImageRoom(
            quote = quote,
            typeJoke = typeJoke,
            firstLine = firstLine,
            secondLine = secondLine,
            safe = safe
        )

    }
}