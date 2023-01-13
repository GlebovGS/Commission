package com.example.myapplication.domain.registration_usecases

import android.util.Patterns

class ValidateNumberPhoneUseCase {
    fun phoneNumberValidate(p0: String): ValidationResult
    {
        if(p0.isBlank()){
            return ValidationResult(successful = false,errorMassage = "Введите номер телефона")
        }
        if(!Patterns.PHONE.matcher(p0).matches()){
            return ValidationResult(successful = false,errorMassage = "Неверный формат номера телефона")
        }
        return ValidationResult(successful = true)
    }
}