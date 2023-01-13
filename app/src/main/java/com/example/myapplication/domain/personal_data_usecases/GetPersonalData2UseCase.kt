package com.example.myapplication.domain.personal_data_usecases

class GetPersonalData2UseCase(private val user_personal_data_2_repository: IUserPersonalData2Repository) {

    fun getPersonalData_P(): List<String>
    {
        return user_personal_data_2_repository.personalData_P_Get()
    }

    fun getPersonalData_R(): List<String>
    {
        return user_personal_data_2_repository.personalData_R_Get()
    }

    fun getSameAddress(): Boolean
    {
        return user_personal_data_2_repository.same_address_Get()
    }

    fun getNeedHostel():Boolean
    {
        return user_personal_data_2_repository.needHostel_Get()
    }
}