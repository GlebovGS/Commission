package com.example.myapplication.domain.personal_data_usecases

interface IUserPersonalData2Repository {

    // Для места проживания
    fun personalData_P_Save(p0: List<String>): Boolean

//    fun locality_P_Save(p0: String): Boolean
//    fun region_P_Save(p0: String): Boolean
//    fun district_P_Save(p0: String): Boolean
//    fun street_P_Save(p0: String): Boolean
//    fun house_P_Save(p0: String): Boolean
//    fun flat_P_Save(p0: String): Boolean
//    fun index_P_Save(p0: String): Boolean

    fun personalData_P_Get(): List<String>

//    fun locality_P_Get(): String
//    fun region_P_Get(): String
//    fun district_P_Get(): String
//    fun street_P_Get(): String
//    fun house_P_Get(): String
//    fun flat_P_Get(): String
//    fun index_P_Get(): String

    // Одинаковые ли адреса
    fun same_address_Save(p0: Boolean): Boolean
    fun same_address_Get():Boolean

    // Нужно ли общежитие
    fun needHostel_Save(p0: Boolean): Boolean
    fun needHostel_Get():Boolean

    // Для места регистрации
    fun personalData_R_Save(p0: List<String>):Boolean
//    fun locality_R_Save(p0: String): Boolean
//    fun region_R_Save(p0: String): Boolean
//    fun district_R_Save(p0: String): Boolean
//    fun street_R_Save(p0: String): Boolean
//    fun house_R_Save(p0: String): Boolean
//    fun flat_R_Save(p0: String): Boolean
//    fun index_R_Save(p0: String): Boolean

    fun personalData_R_Get(): List<String>
//    fun locality_R_Get(): String
//    fun region_R_Get(): String
//    fun district_R_Get(): String
//    fun street_R_Get(): String
//    fun house_R_Get(): String
//    fun flat_R_Get(): String
//    fun index_R_Get(): String

}