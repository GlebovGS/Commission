package com.example.myapplication.presentation.personal_data_activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.personal_data_usecases.SaveParentsDataUseCase
import com.example.myapplication.domain.registration_usecases.ValidateNameUseCase
import com.example.myapplication.domain.registration_usecases.ValidateNumberPhoneUseCase
import com.example.myapplication.domain.registration_usecases.ValidationResult

class PersonalData3ViewModel(private val save_parents_data:SaveParentsDataUseCase,
                             private val validate_name:ValidateNameUseCase,
                             private val validate_phone:ValidateNumberPhoneUseCase):ViewModel() {

    private val validationResult1Mut = MutableLiveData<ValidationResult>()
    private val validationResult2Mut = MutableLiveData<ValidationResult>()
    private val validationResult3Mut = MutableLiveData<ValidationResult>()
    private val validationResult4Mut = MutableLiveData<ValidationResult>()
    private val validationResult5Mut = MutableLiveData<ValidationResult>()
    private val validationResult6Mut = MutableLiveData<ValidationResult>()
    private val validationResult7Mut = MutableLiveData<ValidationResult>()
    private val validationResult8Mut = MutableLiveData<ValidationResult>()

    val validationResult1: LiveData<ValidationResult> = validationResult1Mut
    val validationResult2: LiveData<ValidationResult> = validationResult2Mut
    val validationResult3: LiveData<ValidationResult> = validationResult3Mut
    val validationResult4: LiveData<ValidationResult> = validationResult4Mut
    val validationResult5: LiveData<ValidationResult> = validationResult5Mut
    val validationResult6: LiveData<ValidationResult> = validationResult6Mut
    val validationResult7: LiveData<ValidationResult> = validationResult7Mut
    val validationResult8: LiveData<ValidationResult> = validationResult8Mut

    fun save(p0:String,p1:String,p2:String,p3:String,p4:String,
             p5:String,p6:String,p7:String,p8:String,p9:String)
    {
        validationResult1Mut.value = validate_name.nameValidate(p0)
        validationResult2Mut.value = validate_name.nameValidate(p1)
        validationResult3Mut.value = validate_name.nameValidate(p2)
        validationResult4Mut.value = validate_phone.phoneNumberValidate(p3)

        validationResult5Mut.value = validate_name.nameValidate(p5)
        validationResult6Mut.value = validate_name.nameValidate(p6)
        validationResult7Mut.value = validate_name.nameValidate(p7)
        validationResult8Mut.value = validate_phone.phoneNumberValidate(p8)


        if(validationResult1Mut.value!!.successful &&
            validationResult2Mut.value!!.successful &&
            validationResult3Mut.value!!.successful &&
            validationResult4Mut.value!!.successful &&
            validationResult5Mut.value!!.successful &&
            validationResult6Mut.value!!.successful &&
            validationResult7Mut.value!!.successful &&
            validationResult8Mut.value!!.successful)
        {
            val father_data_list = listOf(p0,p1,p2,p3,p4)
            val mother_data_list = listOf(p5,p6,p7,p8,p9)
            val saveResult1 = save_parents_data.saveFatherData(father_data_list)
            val saveResult2 = save_parents_data.saveMotherData(mother_data_list)
        }
    }
}