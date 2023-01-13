package com.example.myapplication.domain.personal_data_usecases

import com.example.myapplication.domain.registration_usecases.ValidationResult

class ValidateIndexUseCase {
    fun indexValidate(p0:String):ValidationResult{ // Почтовый индекс
        if(p0.isBlank()){
            return ValidationResult(successful = false,errorMassage = "Поле не может быть пустым!")
        }
        if(!Regex("[0-9]{6}").matches(p0)){

            return ValidationResult(successful = false,errorMassage = "Поле должно содержать 6 цифр")
        }
        return ValidationResult(successful = true, errorMassage = null)
    }
}