package com.example.myapplication.domain.registration_usecases

interface IUserContactsRepository {
    fun emailSave(p0: String): Boolean
    fun phoneNumberSave(p0: String): Boolean
    fun otherContactsSave(p0: String): Boolean

    fun emailGet(): String
    fun phoneNumberGet(): String
    fun otherContactsGet(): String
}