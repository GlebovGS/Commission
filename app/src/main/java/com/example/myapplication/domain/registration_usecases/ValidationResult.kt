package com.example.myapplication.domain.registration_usecases

data class ValidationResult(
    val successful: Boolean,
    val errorMassage: String? =null
)
