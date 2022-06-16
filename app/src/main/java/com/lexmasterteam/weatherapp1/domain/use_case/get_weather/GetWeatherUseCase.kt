package com.lexmasterteam.weatherapp1.domain.use_case.get_weather

import android.util.Log
import com.lexmasterteam.weatherapp1.common.Resource
import com.lexmasterteam.weatherapp1.data.remote.dto.toWeatherItem
import com.lexmasterteam.weatherapp1.data.repository.WeatherRepositoryImpl
import com.lexmasterteam.weatherapp1.domain.model.WeatherItem
import com.lexmasterteam.weatherapp1.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepositoryImpl
) {
    // nadpisywanie invoke -> jeden use ma mieć dokładnie jedną funkcję!
    // można użyc tego w wielu viewModelach!

    operator fun invoke(lat: String, lon: String, APIKEY: String): Flow<Resource<WeatherItem>> = flow {
        try {

            emit(Resource.Loading())

            val weatherItem = repository.getWeather(lat, lon, APIKEY).toWeatherItem()
            emit(Resource.Succes(weatherItem))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}