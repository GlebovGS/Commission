package com.example.myapplication.presentation.registration_activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.registration_usecases.SaveContactsUseCase
import com.example.myapplication.domain.registration_usecases.ValidateEmailUseCase
import com.example.myapplication.domain.registration_usecases.ValidateNumberPhoneUseCase
import com.example.myapplication.domain.registration_usecases.ValidationResult

class Reg4ViewModel(private val validate_email: ValidateEmailUseCase,
                    private val validate_phone: ValidateNumberPhoneUseCase,
                    private val save_contacts: SaveContactsUseCase
): ViewModel() {

    private val validationResult1Mut = MutableLiveData<ValidationResult>()
    private val validationResult2Mut = MutableLiveData<ValidationResult>()
    //private val validationResult3Mut = MutableLiveData<ValidationResult>()

    val validationResult1: LiveData<ValidationResult> = validationResult1Mut
    val validationResult2: LiveData<ValidationResult> = validationResult2Mut
    //val validationResult3: LiveData<ValidationResult> = validationResult3Mut


    fun save(p0:String,p1:String,p2:String)
    {
        validationResult1Mut.value = validate_email.emailValidate(p0)
        validationResult2Mut.value = validate_phone.phoneNumberValidate(p1)

        if(validationResult1Mut.value!!.successful &&
            validationResult2Mut.value!!.successful)
        {
            val saveResult1 = save_contacts.saveEmail(p0)
            val saveResult2 = save_contacts.savePhoneNumber(p1)
            val saveResult3 = save_contacts.saveOtherContacts(p2)
        }
    }
}