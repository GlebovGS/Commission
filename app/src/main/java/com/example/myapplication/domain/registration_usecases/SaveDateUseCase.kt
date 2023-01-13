package com.example.myapplication.domain.registration_usecases

class SaveDateUseCase(private val user_date_repository: IUserDateRepository) {
    fun saveDate(p0:String):Boolean{
        return user_date_repository.dateSave(p0)
    }
}