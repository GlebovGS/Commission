package com.example.myapplication.domain.personal_data_usecases

class GetParentsDataUseCase(private val user_parents_data_repository:IUserParentsDataRepository) {

    fun getFatherData(): List<String> {
        return user_parents_data_repository.fatherDataGet()
    }

    fun getMotherData(): List<String>{
        return user_parents_data_repository.motherDataGet()
    }
}