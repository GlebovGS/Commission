package com.example.myapplication.domain.personal_data_usecases

import com.example.myapplication.domain.registration_usecases.ValidationResult

class ValidateINNUseCase(){
    fun INNValidate(p0: String): ValidationResult
    {
        if(p0.isNotBlank()){ // ИНН может не быть, но если его начали вводить, идет проверка
            if(!Regex("[0-9]{10}").matches(p0)){

                return ValidationResult(successful = false,errorMassage = "Поле должно содержать 10 цифр")
            }
        }

        return ValidationResult(successful = true)
    }
}