package com.resonance.myfitness.di

import android.app.Application
import com.resonance.myfitness.application.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideApp(app: App): Application = app
}