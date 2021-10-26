package com.example.myapplication3.dogapi.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.myapplication3.dogapi.model.DogImageRoom
import com.example.myapplication3.dogapi.model.DogImageUi
import com.example.myapplication3.dogapi.repository.DogImageQuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DogImageViewModel: ViewModel() {
    private val mDogImageQuoteRepository: DogImageQuoteRepository by lazy { DogImageQuoteRepository() }
    var mDogImageQuoteLiveData: LiveData<List<DogImageUi>> =
        mDogImageQuoteRepository.selectAllDogImageQuote().map {
            it.toUi()
        }


    fun fetchNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            mDogImageQuoteRepository.fetchData()
        }
    }




    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            mDogImageQuoteRepository.deleteAllDogImageQuote()
        }
    }
}


private fun List<DogImageRoom>.toUi(): List<DogImageUi> {
    return asSequence().map {
        DogImageUi(
            quote = it.quote,
            typeJoke = it.typeJoke,
            firstLine = it.firstLine,
            secondLine = it.secondLine,
            safe = it.safe

        )
    }.toList()

}