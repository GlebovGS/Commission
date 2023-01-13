package com.example.myapplication.domain.registration_usecases

interface IUserLoginPasswordRepository {
    fun loginSave(p0: String): Boolean
    fun passwordSave(p0: String): Boolean

    fun loginGet(): String
    fun passwordGet(): String
}