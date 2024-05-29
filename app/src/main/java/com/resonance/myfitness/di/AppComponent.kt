package com.resonance.myfitness.di

import androidx.lifecycle.ViewModel
import com.resonance.myfitness.application.App
import com.resonance.myfitness.ui.auth.AuthViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [])
@Singleton
interface AppComponent {
    fun inject(viewModel: AuthViewModel)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(app: App): Builder
        fun build(): AppComponent
    }
}