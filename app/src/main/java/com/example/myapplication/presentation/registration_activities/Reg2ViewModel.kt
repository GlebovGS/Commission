package com.example.myapplication.presentation.registration_activities

import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.registration_usecases.SaveDateUseCase

class Reg2ViewModel(private val save_date: SaveDateUseCase
): ViewModel() {

    fun save(p0:String)
    {
            val saveResult = save_date.saveDate(p0)
    }
}