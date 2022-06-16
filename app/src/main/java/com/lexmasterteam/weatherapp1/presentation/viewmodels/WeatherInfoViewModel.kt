package com.lexmasterteam.weatherapp1.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lexmasterteam.weatherapp1.common.Constants
import com.lexmasterteam.weatherapp1.common.Resource
import com.lexmasterteam.weatherapp1.domain.model.WeatherItem
import com.lexmasterteam.weatherapp1.domain.use_case.get_weather.GetWeatherUseCase
import com.lexmasterteam.weatherapp1.presentation.states.WeatherState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherInfoViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
): ViewModel(){
    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state

    init {
        getWeather(Constants.LAT,Constants.LON,Constants.API_KEY)
    }



    private fun getWeather(lat:String,lon:String,APIKEY:String){
        getWeatherUseCase(lat, lon, APIKEY).onEach { result ->
            when(result){
                is Resource.Succes->{
                    _state.value = WeatherState(weatherInfo = result.data)
                }
                is Resource.Error ->{
                    _state.value = WeatherState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading ->{
                    _state.value = WeatherState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}