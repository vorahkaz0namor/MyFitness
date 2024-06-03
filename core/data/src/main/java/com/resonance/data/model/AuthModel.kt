package com.resonance.data.model

data class LoginRequest(
    val email: String? = null,
)

data class ConfirmRequest(
    val password: String? = null,
)

data class AuthResponse(
    val token: String? = null,
): ResponseModel