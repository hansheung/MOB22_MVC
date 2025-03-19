package com.hansheung.mob22.model

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WeatherRepo {

    fun getRandomWeather(): Weather{
        val formatter = SimpleDateFormat("hh:mm:ss dd MMM yyy", Locale.getDefault())
        val time = formatter.format(Date())
        val temp = (20..37).random()
        val wind = (0..10).random()
        val humidity = (50..100).random()
        return Weather(
            time,
            temp.toFloat(),
            wind.toFloat(),
            humidity.toFloat()
        )
    }
}