package com.example.myapplication.presentation.registration_activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.registration_usecases.SaveNameUseCase
import com.example.myapplication.domain.registration_usecases.ValidateNameUseCase
import com.example.myapplication.domain.registration_usecases.ValidationResult

class Reg1ViewModel(private val validate_name: ValidateNameUseCase,
                    private val save_name: SaveNameUseCase
): ViewModel() {

    private val validationResult1Mut = MutableLiveData<ValidationResult>()
    private val validationResult2Mut = MutableLiveData<ValidationResult>()
    private val validationResult3Mut = MutableLiveData<ValidationResult>()

    val validationResult1:LiveData<ValidationResult> = validationResult1Mut
    val validationResult2:LiveData<ValidationResult> = validationResult2Mut
    val validationResult3:LiveData<ValidationResult> = validationResult3Mut


    fun save(p0:String,p1:String,p2:String)
    {
        validationResult1Mut.value = validate_name.nameValidate(p0)
        validationResult2Mut.value = validate_name.nameValidate(p1)
        validationResult3Mut.value = validate_name.nameValidate(p2)

        if(validationResult1Mut.value!!.successful &&
            validationResult2Mut.value!!.successful &&
            validationResult3Mut.value!!.successful)
        {
            val saveResult1 = save_name.saveName(p0)
            val saveResult2 = save_name.saveLastName(p1)
            val saveResult3=  save_name.savePatronymic(p2)
        }
    }
}