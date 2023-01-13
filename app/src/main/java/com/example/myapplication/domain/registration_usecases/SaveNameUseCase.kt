package com.example.myapplication.domain.registration_usecases

class SaveNameUseCase(private var user_name_repository: IUserNameRepository) {

    fun saveLastName(p0:String):Boolean{
        return user_name_repository.lastNameSave(p0)
    }
    fun saveName(p0:String):Boolean{
        return user_name_repository.nameSave(p0)
    }
    fun savePatronymic(p0:String):Boolean{
        return user_name_repository.patronymicSave(p0)
    }
}