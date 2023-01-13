package com.example.myapplication.domain.registration_usecases

class GetNameUseCase(private val user_name_respository: IUserNameRepository) {

    fun getLastName():String{
        return user_name_respository.lastNameGet()
    }

    fun getName():String{
        return user_name_respository.nameGet()
    }

    fun getPatronymic():String{
        return user_name_respository.patronymicGet()
    }

}