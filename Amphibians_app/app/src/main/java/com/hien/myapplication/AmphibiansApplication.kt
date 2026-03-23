package com.hien.myapplication

import android.app.Application
import com.hien.myapplication.data.AppContainer
import com.hien.myapplication.data.DefaultAppContainer

class AmphibiansApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
