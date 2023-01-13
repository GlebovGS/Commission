package com.example.myapplication.data.personal_data_repositories

import android.content.Context
import com.example.myapplication.domain.personal_data_usecases.IUserPersonalData2Repository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.ArrayList


private const val SP_PERSONAL_DATA2 = "sp_personal_data2"
private const val KEY_DATA_LIST_P = "data_list_p"
private const val KEY_DATA_LIST_R = "data_list_r"
private const val KEY_NEED_HOSTEL = "need_hostel"
private const val KEY_SAME_ADDRESS = "same_address"
private const val DEFAULT = "default_value"
private const val DEFAULT_BOOLEAN = false

class UserPersonalData2RepositoryImpl(context: Context): IUserPersonalData2Repository {


    val sharedPreferences = context.getSharedPreferences(SP_PERSONAL_DATA2,Context.MODE_PRIVATE)

    override fun personalData_P_Save(p0: List<String>): Boolean {
        val gson = Gson()
        val json: String = gson.toJson(p0)
        sharedPreferences.edit().putString(KEY_DATA_LIST_P, json).apply()
        return true
    }

    override fun personalData_P_Get(): List<String> {
        val gson = Gson()
        val json: String = sharedPreferences.getString(KEY_DATA_LIST_P, DEFAULT)?:DEFAULT
        val type: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return gson.fromJson(json, type)
    }

    override fun same_address_Save(p0: Boolean): Boolean {
       sharedPreferences.edit().putBoolean(KEY_SAME_ADDRESS,p0).apply()
        return true
    }

    override fun same_address_Get(): Boolean {
        return sharedPreferences.getBoolean(KEY_SAME_ADDRESS,DEFAULT_BOOLEAN)
    }

    override fun needHostel_Save(p0: Boolean): Boolean {
        sharedPreferences.edit().putBoolean(KEY_NEED_HOSTEL,p0).apply()
        return true
    }

    override fun needHostel_Get(): Boolean {
        return sharedPreferences.getBoolean(KEY_NEED_HOSTEL,DEFAULT_BOOLEAN)
    }

    override fun personalData_R_Save(p0: List<String>): Boolean {
        val gson = Gson()
        val json: String = gson.toJson(p0)
        sharedPreferences.edit().putString(KEY_DATA_LIST_R, json).apply()
        return true
    }

    override fun personalData_R_Get(): List<String> {
        val gson = Gson()
        val json: String = sharedPreferences.getString(KEY_DATA_LIST_R, DEFAULT)?:DEFAULT
        val type: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return gson.fromJson(json, type)
    }
}