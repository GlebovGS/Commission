package com.example.myapplication.presentation.personal_data_activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.personal_data_usecases.GetParentsDataUseCase
import com.example.myapplication.domain.personal_data_usecases.GetPersonalData1UseCase
import com.example.myapplication.domain.personal_data_usecases.GetPersonalData2UseCase

class ConfirmPersonalDataViewModel(private val get_personal_data1:GetPersonalData1UseCase,
                                   private val get_personal_data2: GetPersonalData2UseCase,
                                   private val get_parents_data:GetParentsDataUseCase):ViewModel(){

    private val GetResult1 = MutableLiveData<String>()       // Гражданство
    private val GetResult2 = MutableLiveData<String>()       // ИНН
    private val GetResult3 = MutableLiveData<String>()       // Изучаемый язык
    private val GetResult4 = MutableLiveData<Boolean>()      // Нужно ли общежитие
    private val GetResult5 = MutableLiveData<List<String>>() // Адрес регистрации
    private val GetResult6 = MutableLiveData<Boolean>()      // Одинаковый ли адрес
    private val GetResult7 = MutableLiveData<List<String>>() // Адрес проживания
    private val GetResult8 = MutableLiveData<List<String>>() // Данные отца
    private val GetResult9 = MutableLiveData<List<String>>() // Данные матери

    val Citizenship: LiveData<String> = GetResult1
    val INN: LiveData<String> = GetResult2
    val LearningLanguage: LiveData<String> = GetResult3
    val NeedHostel: LiveData<Boolean> = GetResult4
    val ListAddressR: LiveData<List<String>> = GetResult5
    val SameAddress: LiveData<Boolean> = GetResult6
    val ListAddressP: LiveData<List<String>> = GetResult7
    val ListFatherData: LiveData<List<String>> = GetResult8
    val ListMotherData: LiveData<List<String>> = GetResult9

    fun get(){

        GetResult1.value = get_personal_data1.getCitizenship()
        GetResult2.value = get_personal_data1.getINN()
        GetResult3.value = get_personal_data1.getLearningLanguage()

        GetResult4.value = get_personal_data2.getNeedHostel()
        GetResult5.value = get_personal_data2.getPersonalData_R()
        GetResult6.value = get_personal_data2.getSameAddress()
        GetResult7.value = get_personal_data2.getPersonalData_P()

        GetResult8.value = get_parents_data.getFatherData()
        GetResult9.value = get_parents_data.getMotherData()
    }
}