package com.example.myapplication.data.personal_data_repositories

import android.content.Context
import com.example.myapplication.domain.personal_data_usecases.IUserPersonalData1Repository

private const val SP_PERSONAL_DATA1 = "sp_personal_data1"
private const val KEY_INN = "inn"
private const val KEY_CITIZENSHIP = "citizenship"
private const val KEY_LEARNING_LANGUAGE = "learning_language"
private const val DEFAULT = "default_value"

class UserPersonalData1RepositoryImpl(context: Context): IUserPersonalData1Repository {

    val sharedPreferences = context.getSharedPreferences(SP_PERSONAL_DATA1,Context.MODE_PRIVATE)

    override fun INNSave(p0: String): Boolean {
        sharedPreferences.edit().putString(KEY_INN,p0).apply()
        return true
    }

    override fun citizenshipSave(p0: String): Boolean {
        sharedPreferences.edit().putString(KEY_CITIZENSHIP,p0).apply()
        return true
    }

    override fun learningLanguageSave(p0: String): Boolean {
        sharedPreferences.edit().putString(KEY_LEARNING_LANGUAGE,p0).apply()
        return true
    }

    override fun INNGet(): String {
        return sharedPreferences.getString(KEY_INN,DEFAULT)?:DEFAULT
    }

    override fun citizenshipGet(): String {
        return sharedPreferences.getString(KEY_CITIZENSHIP,DEFAULT)?:DEFAULT
    }

    override fun learningLanguageGet(): String {
        return sharedPreferences.getString(KEY_LEARNING_LANGUAGE,DEFAULT)?:DEFAULT
    }
}