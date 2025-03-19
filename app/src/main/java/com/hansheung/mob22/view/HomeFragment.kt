package com.hansheung.mob22.view

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hansheung.mob22.controller.HomeController
import com.hansheung.mob22.databinding.FragmentHomeBinding
import com.hansheung.mob22.model.Weather


import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

//Implement Interface. You can implement many interface
@AndroidEntryPoint
class HomeFragment : Fragment(), HomeView {

    private lateinit var binding: FragmentHomeBinding
    private val controller = HomeController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            //make sure ui is ready
            repeatOnLifecycle(Lifecycle.State.RESUMED){
                controller.refresh()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRefresh.setOnClickListener{
            controller.refresh()
        }
    }

    override fun updateWeatherView(weather: Weather) {
        binding.run {
            tvTime.text = "Time: ${weather.time}"
            tvTemp.text = "Temp: ${weather.temperature}"
            tvWind.text = "Wind: ${weather.wind}"
            tvHumidity.text = "Humidity: ${weather.humidity}"
        }
    }
}

interface HomeView {
    fun updateWeatherView(weather: Weather)
}