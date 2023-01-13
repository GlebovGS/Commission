package com.example.myapplication.domain.registration_usecases

class GetLoginPaswordUseCase(private val user_login_password_respository: IUserLoginPasswordRepository) {

    fun getlogin():String{
        return user_login_password_respository.loginGet()
    }

  //  fun getPassword():String{
  //      return user_login_password_respository.passwordGet()
  // }

}