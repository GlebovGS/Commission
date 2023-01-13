package com.example.myapplication.data.registration_repositories

import android.content.Context
import com.example.myapplication.domain.registration_usecases.IUserDateRepository

private const val SP_DATE = "sp_date"
private const val KEY_DATE = "date"
private const val DEFAULT = "default_value"

class UserDateRepositoryImpl(private val context: Context): IUserDateRepository {

    val sharedPreferences = context.getSharedPreferences(SP_DATE,Context.MODE_PRIVATE)

    override fun dateSave(p0: String): Boolean {
        sharedPreferences.edit().putString(KEY_DATE,p0).apply()
        return true
    }

    override fun dateGet(): String {
        return sharedPreferences.getString(KEY_DATE,DEFAULT)?:DEFAULT
    }
}