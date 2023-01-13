package com.example.myapplication.data.registration_repositories

import android.content.Context
import com.example.myapplication.domain.registration_usecases.IUserContactsRepository

private const val SP_CONTACTS = "sp_contacts"
private const val KEY_EMAIL = "email"
private const val KEY_PHONE = "phone"
private const val KEY_OTHER_CONTACTS = "other_contacts"
private const val DEFAULT = "default_value"
private const val DEFAULT_CONTACTS = "Не указано"

class UserContactsRepositoryImpl(context: Context): IUserContactsRepository {

    val sharedPreferences = context.getSharedPreferences(SP_CONTACTS,Context.MODE_PRIVATE)

    override fun emailSave(p0: String): Boolean {
        sharedPreferences.edit().putString(KEY_EMAIL,p0).apply()
        return true
    }

    override fun phoneNumberSave(p0: String): Boolean {
        sharedPreferences.edit().putString(KEY_PHONE,p0).apply()
        return true
    }

    override fun otherContactsSave(p0: String): Boolean {
        sharedPreferences.edit().putString(KEY_OTHER_CONTACTS,p0).apply()
        return true
    }

    override fun emailGet(): String {
        return sharedPreferences.getString(KEY_EMAIL,DEFAULT)?:DEFAULT
    }

    override fun phoneNumberGet(): String {
        return sharedPreferences.getString(KEY_PHONE,DEFAULT)?:DEFAULT
    }

    override fun otherContactsGet(): String {
        return sharedPreferences.getString(KEY_OTHER_CONTACTS,DEFAULT_CONTACTS)?:DEFAULT_CONTACTS
    }
}