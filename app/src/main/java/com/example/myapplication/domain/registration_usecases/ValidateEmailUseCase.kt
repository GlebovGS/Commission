package com.example.myapplication.domain.registration_usecases

import android.util.Patterns

class ValidateEmailUseCase {
    fun emailValidate(p0: String): ValidationResult // для почты
    {
        if(p0.isBlank()){
            return ValidationResult(successful = false,errorMassage = "Поле не может быть пустым!")
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(p0).matches()){
            return ValidationResult(successful = false,errorMassage = "Вы ввели не email!")
        }
        return ValidationResult(successful = true)
    }
}