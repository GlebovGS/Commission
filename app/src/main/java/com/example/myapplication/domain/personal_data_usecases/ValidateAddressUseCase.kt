package com.example.myapplication.domain.personal_data_usecases

import com.example.myapplication.domain.registration_usecases.ValidationResult

class ValidateAddressUseCase {
    fun addressValidate(p0:String):ValidationResult{
        if(p0.isBlank()){
            return ValidationResult(successful = false,errorMassage = "Поле не может быть пустым!")
        }
        return ValidationResult(successful = true, errorMassage = null)
    }

}