package com.example.myapplication.presentation.application_form_activities

data class UserPriority (val documentNumber:Int, val educationForm:String,
                         val course:Int, val faculty:String,
                         val cipher:String, val profile:String,
                         val specialityTitle:String, var priority:Int)