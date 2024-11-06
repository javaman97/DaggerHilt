package com.aman.daggerhilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module // Will make this class a module to inject dependency to other classes within its scope.
@InstallIn(SingletonComponent::class)  //  this will make this class inject dependencies across the entire application.
class AppModule {
    @Provides
    @Singleton // Singleton Annotation so that whenever we inject the dependency we inject the same single instance of CryptocurrencyRepository were ever requested
    fun provideCryptoCurrency(): CryptoRepository = CryptoCurrencyImpl()
}