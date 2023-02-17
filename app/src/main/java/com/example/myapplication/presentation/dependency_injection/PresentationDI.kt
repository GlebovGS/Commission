package com.example.myapplication.presentation.dependency_injection

import com.example.myapplication.presentation.addition_documents_activities.AdditionDocumentsViewModel
import com.example.myapplication.presentation.addition_documents_activities.AdditionPhotoViewModel
import com.example.myapplication.presentation.personal_data_activities.ConfirmPersonalDataViewModel
import com.example.myapplication.presentation.personal_data_activities.PersonalData1ViewModel
import com.example.myapplication.presentation.personal_data_activities.PersonalData2ViewModel
import com.example.myapplication.presentation.personal_data_activities.PersonalData3ViewModel
import com.example.myapplication.presentation.registration_activities.*
import com.example.myapplication.presentation.navigation_fragments.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presentationModule = module {

    viewModel<Reg1ViewModel> {
        Reg1ViewModel(validate_name = get(), save_name = get())
    }
    viewModel<Reg2ViewModel> {
        Reg2ViewModel(save_date = get())
    }
    viewModel<Reg3ViewModel> {
        Reg3ViewModel(validate_login = get(), validate_password = get(),
            validate_repeated_password = get(), save_login_password = get())
    }
    viewModel<Reg4ViewModel> {
        Reg4ViewModel(validate_email = get(), validate_phone = get(), save_contacts = get())
    }

    viewModel<ConfirmRegViewModel> {
        ConfirmRegViewModel(getNameUseCase = get(), getDateUseCase = get(), getLoginUseCase = get(), getContactsUseCase = get())
    }

    viewModel<PersonalData1ViewModel> {
        PersonalData1ViewModel(save_personal_data1 = get(), validateINN = get(), validate_citizenship = get())
    }
    viewModel<PersonalData2ViewModel> {
        PersonalData2ViewModel(save_personal_data2 = get(), validate_address = get(), validate_index = get())
    }
    viewModel<PersonalData3ViewModel> {
        PersonalData3ViewModel(save_parents_data = get(), validate_name = get(), validate_phone = get())
    }

    viewModel<ConfirmPersonalDataViewModel> {
        ConfirmPersonalDataViewModel(get_personal_data1 = get(), get_personal_data2 = get(), get_parents_data = get())
    }

    viewModel<AdditionDocumentsViewModel> {
        AdditionDocumentsViewModel(context = get())
    }

    viewModel<AdditionPhotoViewModel> {
        AdditionPhotoViewModel(context = get(), save_photo = get())
    }

    viewModel<ProfileViewModel> {
        ProfileViewModel(getNameUseCase = get(), getPhotoUseCase = get())
    }

}