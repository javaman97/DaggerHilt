package com.aman.daggerhilt

interface CryptoRepository {
    fun getCryptoCurrency(): List<CryptoCurrency>
}