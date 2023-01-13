package com.example.myapplication.domain.registration_usecases

class ValidateRepeatedPasswordUseCase {
    fun repeatedPasswordValidate(p0: String, p1: String): ValidationResult
    {
        if(p0!=p1){
            return ValidationResult(successful = false,errorMassage = "Пароли не совпадают")
        }
        return ValidationResult(successful = true)
    }
}