package com.example.myapplication.domain.personal_data_usecases

class SaveParentsDataUseCase(private val user_parents_data_repository:IUserParentsDataRepository) {
    fun saveFatherData(p0: List<String>):Boolean  {
        user_parents_data_repository.fatherDataSave(p0)
        return true
    }

    fun saveMotherData(p0: List<String>):Boolean {
        user_parents_data_repository.motherDataSave(p0)
        return true
    }
}