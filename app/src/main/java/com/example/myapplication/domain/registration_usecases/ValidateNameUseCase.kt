package com.example.myapplication.domain.registration_usecases

class ValidateNameUseCase {
    fun nameValidate(p0: String): ValidationResult
    {
        if(p0.isBlank()){
            return ValidationResult(successful = false,errorMassage = "Поле не может быть пустым!")
        }
        if(p0.any() {it.isDigit()})
        {
            return ValidationResult(successful = false,errorMassage = "В поле не должно быть цифр")
        }
        if(!Regex("[А-ЯЁа-яё\\s]{1,40}").matches(p0)){
            return ValidationResult(successful = false,errorMassage = "ФИО должно быть на русском языке")
        }
        return ValidationResult(successful = true)
    }
}