package com.example.myapplication.data.personal_data_repositories

import android.content.Context
import com.example.myapplication.domain.personal_data_usecases.IUserParentsDataRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.ArrayList

private const val SP_PARENTS_DATA = "sp_parents_data"
private const val KEY_DATA_FATHER = "data_father"
private const val KEY_DATA_MOTHER = "data_mother"
private const val DEFAULT = "default_value"

class UserParentsDataRepositoryImpl(context:Context): IUserParentsDataRepository {

    val sharedPreferences = context.getSharedPreferences(SP_PARENTS_DATA,Context.MODE_PRIVATE)

    override fun fatherDataSave(p0: List<String>): Boolean {
        val gson = Gson()
        val json: String = gson.toJson(p0)
        sharedPreferences.edit().putString(KEY_DATA_FATHER, json).apply()
        return true
    }

    override fun fatherDataGet(): List<String> {
        val gson = Gson()
        val json: String = sharedPreferences.getString(KEY_DATA_FATHER, DEFAULT)?:DEFAULT
        val type: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return gson.fromJson(json, type)
    }

    override fun motherDataSave(p0: List<String>): Boolean {
        val gson = Gson()
        val json: String = gson.toJson(p0)
        sharedPreferences.edit().putString(KEY_DATA_MOTHER, json).apply()
        return true
    }

    override fun motherDataGet(): List<String> {
        val gson = Gson()
        val json: String = sharedPreferences.getString(KEY_DATA_MOTHER, DEFAULT)?:DEFAULT
        val type: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return gson.fromJson(json, type)
    }
}