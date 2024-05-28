package com.resonance.myfitness.application

import android.app.Application
import com.resonance.myfitness.di.AppComponent
import com.resonance.myfitness.di.DaggerAppComponent

class App : Application() {
    companion object {
        private lateinit var appComponent: AppComponent

        fun getAppComponent(): AppComponent = appComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().app(this).build()
    }
}