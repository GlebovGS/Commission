package com.example.myapplication.domain.registration_usecases

class ValidatePasswordUseCase {
    fun passwordValidate(p0: String): ValidationResult
    {
        if(p0.length<8){
            return ValidationResult(successful = false,errorMassage = "Пароль должен быть не менее 8 символов")
        }

        if(!p0.any{it.isDigit()}&&p0.any(){it.isLetter()}){
            return ValidationResult(successful = false,errorMassage = "Пароль должен содержать цифры и буквы")
        }
        return ValidationResult(successful = true)
    }
}