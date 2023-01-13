package com.example.myapplication.domain.registration_usecases

interface IUserNameRepository {

        fun lastNameSave(p0: String): Boolean
        fun nameSave(p0: String): Boolean
        fun patronymicSave(p0: String): Boolean

        fun lastNameGet(): String
        fun nameGet(): String
        fun patronymicGet(): String

}