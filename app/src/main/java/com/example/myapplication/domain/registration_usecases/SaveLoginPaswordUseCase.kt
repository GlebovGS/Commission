package com.example.myapplication.domain.registration_usecases

class SaveLoginPaswordUseCase(private val user_login_repository: IUserLoginPasswordRepository) {

    fun saveLogin(p0:String):Boolean{
        return user_login_repository.loginSave(p0)
    }
    fun savePassword(p0:String):Boolean{
        return user_login_repository.passwordSave(p0)
    }
}