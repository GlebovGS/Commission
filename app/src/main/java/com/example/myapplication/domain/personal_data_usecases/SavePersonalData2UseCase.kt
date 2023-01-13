package com.example.myapplication.domain.personal_data_usecases

class SavePersonalData2UseCase(private val user_personal_data_2_repository: IUserPersonalData2Repository) {

    fun savePersonalData_P(p0:List<String>): Boolean
    {
        user_personal_data_2_repository.personalData_P_Save(p0)
        return true
    }

    fun savePersonalData_R(p0:List<String>): Boolean
    {
        user_personal_data_2_repository.personalData_R_Save(p0)
        return true
    }

    fun saveSameAddress(p0:Boolean): Boolean
    {
        user_personal_data_2_repository.same_address_Save(p0)
        return true
    }

    fun saveNeedHostel(p0:Boolean):Boolean
    {
        user_personal_data_2_repository.needHostel_Save(p0)
        return true
    }
}