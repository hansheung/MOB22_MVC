package com.hansheung.mob22.controller

import com.hansheung.mob22.model.Weather
import com.hansheung.mob22.model.WeatherRepo
import com.hansheung.mob22.view.HomeView

class HomeController(val view: HomeView) {
    val weatherRepo = WeatherRepo()

    fun refresh(){
        val weather =weatherRepo.getRandomWeather()
        view.updateWeatherView(weather)
    }

}