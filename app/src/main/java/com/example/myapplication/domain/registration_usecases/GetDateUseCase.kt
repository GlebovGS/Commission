package com.example.myapplication.domain.registration_usecases

class GetDateUseCase(private val user_date_repository: IUserDateRepository) {

    fun getDate():String {
        return user_date_repository.dateGet()
    }
}