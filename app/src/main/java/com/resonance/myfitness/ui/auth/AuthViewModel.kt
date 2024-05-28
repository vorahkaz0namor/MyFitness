package com.resonance.myfitness.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.resonance.data.model.AuthRequest
import com.resonance.myfitness.application.App
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val _authState = MutableStateFlow<AuthState?>(null)
    val authState: StateFlow<AuthState?>
        get() = _authState.asStateFlow()

    init {
        App.getAppComponent().inject(this)
    }

    fun login(authRequest: AuthRequest) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            // onSuccess
            _authState.value = AuthState.Success
            // onError
            _authState.value = AuthState.Error
        }
    }

    fun onErrorAction() {
        _authState.value = null
    }
}