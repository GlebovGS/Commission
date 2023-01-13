package com.example.myapplication.domain.personal_data_usecases

interface IUserParentsDataRepository {

    // Для отца
    fun fatherDataSave(p0: List<String>):Boolean
    fun fatherDataGet():List<String>

//    fun fatherLastnameSave(p0: String): Boolean
//    fun fatherNameSave(p0: String): Boolean
//    fun fatherPatronymicSave(p0: String): Boolean
//    fun fatherPhoneSave(p0: String): Boolean
//    fun fatherAddressSave(p0: String): Boolean
//
//    fun fatherLastnameGet(): String
//    fun fatherNameGet(): String
//    fun fatherPatronymicGet(): String
//    fun fatherPhoneGet(): String
//    fun fatherAddressGet(): String


    // Для матери
    fun motherDataSave(p0: List<String>):Boolean
    fun motherDataGet():List<String>

//    fun motherLastnameSave(p0: String): Boolean
//    fun motherNameSave(p0: String): Boolean
//    fun motherPatronymicSave(p0: String): Boolean
//    fun motherPhoneSave(p0: String): Boolean
//    fun motherAddressSave(p0: String): Boolean
//
//    fun motherLastnameGet(): String
//    fun motherNameGet(): String
//    fun motherPatronymicGet(): String
//    fun motherPhoneGet(): String
//    fun motherAddressGet(): String
}