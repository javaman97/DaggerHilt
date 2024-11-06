package com.aman.daggerhilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// @HiltViewModel will make models to be
// created using Hilt's model factory
// @Inject annotation used to inject all
// dependencies to view model class

@HiltViewModel
class MainVieModel @Inject constructor(private val cryptoRepo:CryptoRepository):
ViewModel(){
    private val cryptoCurrencyEmitter = MutableLiveData<List<CryptoCurrency>>()

    val cryptoCurrency : LiveData<List<CryptoCurrency>> = cryptoCurrencyEmitter

    init {
        loadCrypto()
    }

    private fun loadCrypto() {
        cryptoCurrencyEmitter.value = cryptoRepo.getCryptoCurrency()
    }
}