package com.example.myapplication.domain.registration_usecases

class ValidateLoginUseCase {
    fun loginValidate(p0: String): ValidationResult
    {
        if(p0.isBlank()){
            return ValidationResult(successful = false,errorMassage = "Поле не может быть пустым!")
        }



        return ValidationResult(successful = true)
    }
}