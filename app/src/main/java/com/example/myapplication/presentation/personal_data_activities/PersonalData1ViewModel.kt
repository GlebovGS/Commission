package com.example.myapplication.presentation.personal_data_activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.personal_data_usecases.SavePersonalData1UseCase
import com.example.myapplication.domain.personal_data_usecases.ValidateCitizenshipUseCase
import com.example.myapplication.domain.personal_data_usecases.ValidateINNUseCase
import com.example.myapplication.domain.registration_usecases.ValidationResult

class PersonalData1ViewModel(private val save_personal_data1: SavePersonalData1UseCase,
                             private val validateINN:ValidateINNUseCase,
                             private val validate_citizenship:ValidateCitizenshipUseCase):ViewModel() {

    private val validationResult1Mut = MutableLiveData<ValidationResult>()
    private val validationResult2Mut = MutableLiveData<ValidationResult>()

    val validationResult1: LiveData<ValidationResult> = validationResult1Mut
    val validationResult2: LiveData<ValidationResult> = validationResult2Mut

    fun save(p0:String,p1:String,p2:String)
    {
        validationResult1Mut.value = validate_citizenship.citizenshipValidate(p0)
        validationResult2Mut.value = validateINN.INNValidate(p1)

        if(validationResult1Mut.value!!.successful &&
            validationResult2Mut.value!!.successful)
        {
            val saveResult1 = save_personal_data1.saveCitizenship(p0)
            val saveResult2 = save_personal_data1.saveINN(p1)
            val saveResult3=  save_personal_data1.saveLearningLanguage(p2)
        }
    }
}