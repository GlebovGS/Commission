package com.example.myapplication.presentation.registration_activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.registration_usecases.*

class Reg3ViewModel(private val validate_login: ValidateLoginUseCase,
                    private val validate_password: ValidatePasswordUseCase,
                    private val validate_repeated_password: ValidateRepeatedPasswordUseCase,
                    private val save_login_password: SaveLoginPaswordUseCase
): ViewModel() {

    private val validationResult1Mut = MutableLiveData<ValidationResult>()
    private val validationResult2Mut = MutableLiveData<ValidationResult>()
    private val validationResult3Mut = MutableLiveData<ValidationResult>()

    val validationResult1: LiveData<ValidationResult> = validationResult1Mut
    val validationResult2: LiveData<ValidationResult> = validationResult2Mut
    val validationResult3: LiveData<ValidationResult> = validationResult3Mut


    fun save(p0:String,p1:String,p2:String)
    {
        validationResult1Mut.value = validate_login.loginValidate(p0)
        validationResult2Mut.value = validate_password.passwordValidate(p1)
        validationResult3Mut.value = validate_repeated_password.repeatedPasswordValidate(p1,p2)

        if(validationResult1Mut.value!!.successful &&
            validationResult2Mut.value!!.successful &&
            validationResult3Mut.value!!.successful)
        {
            val saveResult1 = save_login_password.saveLogin(p0)
            val saveResult2 = save_login_password.savePassword(p1)
        }
    }
}