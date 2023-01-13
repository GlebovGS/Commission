package com.example.myapplication.domain.registration_usecases

interface IUserDateRepository {

    fun dateSave(p0: String): Boolean

    fun dateGet(): String
}