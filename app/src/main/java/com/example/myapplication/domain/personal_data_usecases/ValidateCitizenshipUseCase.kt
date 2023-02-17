package com.example.myapplication.domain.personal_data_usecases

import com.example.myapplication.domain.registration_usecases.ValidationResult

class ValidateCitizenshipUseCase {
    fun citizenshipValidate(p0:String):ValidationResult{
        if(p0.isBlank()){
            return ValidationResult(successful = false,errorMassage = "Поле не может быть пустым!")
        }
        if(!Regex("[А-ЯЁа-яё\\s -]+").matches(p0)){

            return ValidationResult(successful = false,errorMassage = "Можно использовать только русские буквы, \"-\" и пробелы")
        }
        return ValidationResult(successful = true)
    }
}