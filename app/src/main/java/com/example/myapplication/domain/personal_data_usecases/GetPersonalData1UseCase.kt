package com.example.myapplication.domain.personal_data_usecases

class GetPersonalData1UseCase(private val user_personal_data_1_repository: IUserPersonalData1Repository) {

    fun getINN(): String
    {
        return  user_personal_data_1_repository.INNGet()
    }
    fun getCitizenship(): String
    {
        return  user_personal_data_1_repository.citizenshipGet()
    }
    fun getLearningLanguage(): String
    {
        return  user_personal_data_1_repository.learningLanguageGet()
    }
}