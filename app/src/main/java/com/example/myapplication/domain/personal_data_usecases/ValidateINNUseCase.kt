package com.example.myapplication.domain.personal_data_usecases

import com.example.myapplication.domain.registration_usecases.ValidationResult

class ValidateINNUseCase(){
    fun INNValidate(p0: String): ValidationResult // для ИНН
    {
        if(p0.isBlank()){
            return ValidationResult(successful = false,errorMassage = "Поле не может быть пустым!")
        }
        if(!Regex("[0-9]{10}").matches(p0)){

            return ValidationResult(successful = false,errorMassage = "Поле должно содержать 10 цифр")
        }
        return ValidationResult(successful = true)
    }
}