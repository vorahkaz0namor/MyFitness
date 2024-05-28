package com.resonance.data.model

data class AuthRequest(
    val email: String? = null,
    val password: String? = null,
)

data class AuthResponse(
    val token: String? = null,
): ResponseModel