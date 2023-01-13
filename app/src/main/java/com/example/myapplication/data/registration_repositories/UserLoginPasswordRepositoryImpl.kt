package com.example.myapplication.data.registration_repositories

import android.content.Context
import com.example.myapplication.domain.registration_usecases.IUserLoginPasswordRepository

private const val SP_LOGPASS = "log_pass"
private const val KEY_LOGIN = "login"
private const val KEY_PASSWORD = "password"
private const val DEFAULT = "default_value"

class UserLoginPasswordRepositoryImpl(private val context:Context): IUserLoginPasswordRepository {

    val sharedPreferences = context.getSharedPreferences(SP_LOGPASS, Context.MODE_PRIVATE)

    override fun loginSave(p0: String): Boolean {
        sharedPreferences.edit().putString(KEY_LOGIN,p0).apply()
        return true
    }

    override fun passwordSave(p0: String): Boolean {
        sharedPreferences.edit().putString(KEY_PASSWORD,p0).apply()
        return true
    }

    override fun loginGet(): String {
        return sharedPreferences.getString(KEY_LOGIN,DEFAULT)?:DEFAULT
    }

    override fun passwordGet(): String {
        return sharedPreferences.getString(KEY_PASSWORD,DEFAULT)?:DEFAULT
    }
}