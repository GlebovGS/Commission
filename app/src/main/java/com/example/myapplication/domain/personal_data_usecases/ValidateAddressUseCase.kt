package com.example.myapplication.domain.personal_data_usecases

import com.example.myapplication.domain.registration_usecases.ValidationResult

class ValidateAddressUseCase {
    fun addressValidate(p0:String):ValidationResult{
        if(p0.isBlank()){
            return ValidationResult(successful = false,errorMassage = "Поле не может быть пустым!")
        }

        if(!Regex("[0-9А-ЯЁа-яё\\s -]+").matches(p0)){
            return ValidationResult(successful = false,errorMassage = "Можно использовать только русские буквы, цифры, \"-\" и пробелы")
        }

        return ValidationResult(successful = true, errorMassage = null)
    }

}