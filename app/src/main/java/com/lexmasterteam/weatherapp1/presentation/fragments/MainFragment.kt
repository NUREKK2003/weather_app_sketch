package com.lexmasterteam.weatherapp1.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import com.lexmasterteam.weatherapp1.R
import com.lexmasterteam.weatherapp1.common.Constants
import com.lexmasterteam.weatherapp1.data.remote.WeatherApi
import com.lexmasterteam.weatherapp1.data.repository.WeatherRepositoryImpl
import com.lexmasterteam.weatherapp1.databinding.FragmentMainBinding
import com.lexmasterteam.weatherapp1.presentation.viewmodels.WeatherInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private val viewModel by viewModels<WeatherInfoViewModel>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //binding.tvCountry.text = viewModel.state.value.weatherInfo.toString()
        if(viewModel.state.value.isLoading)
            Log.d("APIWEATHER",
                viewModel.state.value.toString()
            )
        binding.btTest.setOnClickListener {
            Log.d("APIWEATHER",
                viewModel.state.value.toString()
            )
            if(!viewModel.state.value.isLoading){
                binding.tvCountry.text = viewModel.state.value.weatherInfo?.sys?.country
                binding.tvClouds.text = viewModel.state.value.weatherInfo?.clouds?.all.toString()
                binding.tvDescription.text = viewModel.state.value.weatherInfo?.weather?.get(0)!!.description
                binding.tvLat.text = viewModel.state.value.weatherInfo?.coord?.lat.toString()
                binding.tvLon.text = viewModel.state.value.weatherInfo?.coord?.lon.toString()
                binding.tvFeelsLikeTemp.text = viewModel.state.value.weatherInfo?.main?.feels_like.toString()
                binding.tvHumidity.text = viewModel.state.value.weatherInfo?.main?.humidity.toString()
                binding.tvName.text = viewModel.state.value.weatherInfo?.name
                binding.tvPressure.text = viewModel.state.value.weatherInfo?.main?.pressure.toString()
                binding.tvSunrise.text = viewModel.state.value.weatherInfo?.sys?.sunrise.toString()
                binding.tvSunset.text = viewModel.state.value.weatherInfo?.sys?.sunset.toString()
                binding.tvTemp.text = viewModel.state.value.weatherInfo?.main?.temp.toString()
                binding.tvVisibility.text = viewModel.state.value.weatherInfo?.visibility.toString()+"m"
                binding.tvWindAngle.text = viewModel.state.value.weatherInfo?.wind?.deg.toString()
                binding.tvWindSpeed.text = viewModel.state.value.weatherInfo?.wind?.speed.toString()
            }
        }
        }


    }
