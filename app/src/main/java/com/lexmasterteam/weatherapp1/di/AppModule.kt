package com.lexmasterteam.weatherapp1.di

import com.lexmasterteam.weatherapp1.common.Constants
import com.lexmasterteam.weatherapp1.data.remote.WeatherApi
import com.lexmasterteam.weatherapp1.data.repository.WeatherRepositoryImpl
import com.lexmasterteam.weatherapp1.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun privideWeatherApi():WeatherApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherApi): WeatherRepository{
        return WeatherRepositoryImpl(api)
    }
}