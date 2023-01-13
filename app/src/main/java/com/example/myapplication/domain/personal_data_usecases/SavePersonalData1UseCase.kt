package com.example.myapplication.domain.personal_data_usecases

class SavePersonalData1UseCase(private val user_personal_data_1_repository: IUserPersonalData1Repository) {
    fun saveINN(p0: String): Boolean
    {
        user_personal_data_1_repository.INNSave(p0)
        return true
    }
    fun saveCitizenship(p0: String): Boolean
    {
        user_personal_data_1_repository.citizenshipSave(p0)
        return true
    }
    fun saveLearningLanguage(p0: String): Boolean
    {
        user_personal_data_1_repository.learningLanguageSave(p0)
        return true
    }
}