package com.example.myapplication.presentation.personal_data_activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.personal_data_usecases.SavePersonalData2UseCase
import com.example.myapplication.domain.personal_data_usecases.ValidateAddressUseCase
import com.example.myapplication.domain.personal_data_usecases.ValidateIndexUseCase
import com.example.myapplication.domain.registration_usecases.ValidationResult

class PersonalData2ViewModel(private val save_personal_data2:SavePersonalData2UseCase,
                             private val validate_address:ValidateAddressUseCase,
                             private val validate_index:ValidateIndexUseCase):ViewModel() {

    private val validationResult1Mut = MutableLiveData<ValidationResult>()
    private val validationResult2Mut = MutableLiveData<ValidationResult>()
    private val validationResult3Mut = MutableLiveData<ValidationResult>()
    private val validationResult4Mut = MutableLiveData<ValidationResult>()
    private val validationResult5Mut = MutableLiveData<ValidationResult>()
    private val validationResult6Mut = MutableLiveData<ValidationResult>()

    private val validationResult7Mut = MutableLiveData<ValidationResult>()
    private val validationResult8Mut = MutableLiveData<ValidationResult>()
    private val validationResult9Mut = MutableLiveData<ValidationResult>()
    private val validationResult10Mut = MutableLiveData<ValidationResult>()
    private val validationResult11Mut = MutableLiveData<ValidationResult>()
    private val validationResult12Mut = MutableLiveData<ValidationResult>()

    val validationResult1: LiveData<ValidationResult> = validationResult1Mut
    val validationResult2: LiveData<ValidationResult> = validationResult2Mut
    val validationResult3: LiveData<ValidationResult> = validationResult3Mut
    val validationResult4: LiveData<ValidationResult> = validationResult4Mut
    val validationResult5: LiveData<ValidationResult> = validationResult5Mut
    val validationResult6: LiveData<ValidationResult> = validationResult6Mut
    val validationResult7: LiveData<ValidationResult> = validationResult7Mut
    val validationResult8: LiveData<ValidationResult> = validationResult8Mut
    val validationResult9: LiveData<ValidationResult> = validationResult9Mut
    val validationResult10: LiveData<ValidationResult> = validationResult10Mut
    val validationResult11: LiveData<ValidationResult> = validationResult11Mut
    val validationResult12: LiveData<ValidationResult> = validationResult12Mut


    // p0 - совпадают ли адреса, p1-p7 - адрес регистрации, p8-p14 - адрес проживания, p15 - нужно ли общежитие
    fun validate(p0:Boolean,p1:String,p2:String,p3:String,p4:String,p5:String,p6:String,p7:String,
             p8:String,p9:String,p10:String,p11:String,p12:String,p13:String,p14:String,p15:Boolean) {
        validationResult1Mut.value = validate_address.addressValidate(p1)
        validationResult2Mut.value = validate_address.addressValidate(p2)
        validationResult3Mut.value = validate_address.addressValidate(p3)
        validationResult4Mut.value = validate_address.addressValidate(p4)
        validationResult5Mut.value = validate_address.addressValidate(p5)
        // поле квартиры не обязательно
        validationResult6Mut.value = validate_index.indexValidate(p7)

        if (!p0)//если адреса не совпадают, проверяем остальные поля
        {
            validationResult7Mut.value = validate_address.addressValidate(p8)
            validationResult8Mut.value = validate_address.addressValidate(p9)
            validationResult9Mut.value = validate_address.addressValidate(p10)
            validationResult10Mut.value = validate_address.addressValidate(p11)
            validationResult11Mut.value = validate_address.addressValidate(p12)
            // поле квартиры не обязательно
            validationResult12Mut.value = validate_index.indexValidate(p14)
        }
    }
    fun save(p0:Boolean,p1:String,p2:String,p3:String,p4:String,p5:String,p6:String,p7:String,
                 p8:String,p9:String,p10:String,p11:String,p12:String,p13:String,p14:String,p15:Boolean) {

        if(!p0) {
            val r_address_list =listOf(p1,p2,p3,p4,p5,p6,p7)
            val p_address_list =listOf(p8,p9,p10,p11,p12,p13,p14)
            val saveResult1 = save_personal_data2.savePersonalData_R(r_address_list)
            val saveResult2=  save_personal_data2.saveSameAddress(false)
            val saveResult3 = save_personal_data2.savePersonalData_P(p_address_list)
            val saveResult4=  save_personal_data2.saveNeedHostel(p15)
        }
        else {
            val r_address_list =listOf(p1,p2,p3,p4,p5,p6,p7)
            val saveResult1 = save_personal_data2.savePersonalData_R(r_address_list)
            val saveResult2=  save_personal_data2.saveSameAddress(true)
            val saveResult3 = save_personal_data2.savePersonalData_P(r_address_list)
            val saveResult4=  save_personal_data2.saveNeedHostel(p15)
        }

    }

}