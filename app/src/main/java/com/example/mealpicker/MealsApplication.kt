package com.example.mealpicker

import android.app.Application
import com.example.mealpicker.data.AppContainer
import com.example.mealpicker.data.DefaultAppContainer

class MealsApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(applicationContext)
    }
}