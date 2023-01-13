package com.example.myapplication.data.registration_repositories

import android.content.Context
import com.example.myapplication.domain.registration_usecases.IUserNameRepository

private const val SP_FIO = "fio"
private const val KEY_lAST_NAME = "lastname"
private const val KEY_NAME = "name"
private const val KEY_PATRONYMIC = "patronymic"
private const val DEFAULT = "default_value"

class UserNameRepositoryImpl(private val context:Context): IUserNameRepository {

    val sharedPreferences = context.getSharedPreferences(SP_FIO,Context.MODE_PRIVATE)


    override fun lastNameSave(p0: String): Boolean {
        sharedPreferences.edit().putString(KEY_lAST_NAME,p0).apply()
        return true
    }

    override fun nameSave(p0: String): Boolean {
        sharedPreferences.edit().putString(KEY_NAME,p0).apply()
        return true
    }

    override fun patronymicSave(p0: String): Boolean {
        sharedPreferences.edit().putString(KEY_PATRONYMIC,p0).apply()
        return true
    }

    override fun lastNameGet(): String {
        return sharedPreferences.getString(KEY_lAST_NAME,DEFAULT)?:DEFAULT
    }

    override fun nameGet(): String {
        return sharedPreferences.getString(KEY_NAME,DEFAULT)?:DEFAULT
    }

    override fun patronymicGet(): String {
        return sharedPreferences.getString(KEY_PATRONYMIC,DEFAULT)?:DEFAULT
    }
}