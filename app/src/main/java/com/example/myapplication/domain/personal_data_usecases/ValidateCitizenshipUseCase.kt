package com.example.myapplication.domain.personal_data_usecases

import com.example.myapplication.domain.registration_usecases.ValidationResult

class ValidateCitizenshipUseCase {
    fun citizenshipValidate(p0:String):ValidationResult{
        if(p0.isBlank()){
            return ValidationResult(successful = false,errorMassage = "Поле не может быть пустым!")
        }
        if(!Regex("[А-Яа-яё\\s]+").matches(p0)){

            return ValidationResult(successful = false,errorMassage = "Поле должно содержать только русские буквы")
        }
        return ValidationResult(successful = true)
    }
}