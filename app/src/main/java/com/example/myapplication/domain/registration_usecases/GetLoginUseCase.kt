package com.example.myapplication.domain.registration_usecases

class GetLoginUseCase(private val user_login_password_respository: IUserLoginPasswordRepository) {

    fun getlogin():String{
        return user_login_password_respository.loginGet()
    }

}