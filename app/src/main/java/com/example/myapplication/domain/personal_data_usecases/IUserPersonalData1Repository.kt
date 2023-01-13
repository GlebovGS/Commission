package com.example.myapplication.domain.personal_data_usecases

interface IUserPersonalData1Repository {

    fun INNSave(p0: String): Boolean
    fun citizenshipSave(p0: String): Boolean
    fun learningLanguageSave(p0: String): Boolean

    fun INNGet(): String
    fun citizenshipGet(): String
    fun learningLanguageGet(): String
}