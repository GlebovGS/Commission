package com.example.myapplication.presentation.dependency_injection


import com.example.myapplication.domain.personal_data_usecases.*
import com.example.myapplication.domain.registration_usecases.*
import org.koin.dsl.module

val domainModule = module {
    factory<ValidateNameUseCase> {
        ValidateNameUseCase()
    }
    factory<SaveNameUseCase> {
        SaveNameUseCase(user_name_repository = get())
    }

    factory<ValidateLoginUseCase> {
        ValidateLoginUseCase()
    }
    factory<ValidatePasswordUseCase>{
        ValidatePasswordUseCase()
    }
    factory<ValidateRepeatedPasswordUseCase>{
        ValidateRepeatedPasswordUseCase()
    }
    factory<SaveLoginPaswordUseCase> {
        SaveLoginPaswordUseCase(user_login_repository = get())
    }

    factory<ValidateNumberPhoneUseCase> {
        ValidateNumberPhoneUseCase()
    }
    factory<ValidateEmailUseCase> {
        ValidateEmailUseCase()
    }
    factory<SaveContactsUseCase> {
        SaveContactsUseCase(user_contacts_repository = get())
    }

    factory<SaveDateUseCase>{
        SaveDateUseCase(user_date_repository = get())
    }

    factory<GetNameUseCase>{
        GetNameUseCase(user_name_respository = get())
    }
    factory<GetDateUseCase>{
        GetDateUseCase(user_date_repository = get())
    }
    factory<GetLoginPaswordUseCase>{
        GetLoginPaswordUseCase(user_login_password_respository = get())
    }
    factory<GetContactsUseCase>{
        GetContactsUseCase(user_contacts_respository = get())
    }



    factory<ValidateINNUseCase> {
        ValidateINNUseCase()
    }
    factory<ValidateCitizenshipUseCase> {
        ValidateCitizenshipUseCase()
    }
    factory<ValidateIndexUseCase> {
        ValidateIndexUseCase()
    }
    factory<ValidateAddressUseCase> {
        ValidateAddressUseCase()
    }

    factory<SavePersonalData1UseCase> {
        SavePersonalData1UseCase(user_personal_data_1_repository = get())
    }
    factory<SavePersonalData2UseCase> {
        SavePersonalData2UseCase(user_personal_data_2_repository = get())
    }
    factory<SaveParentsDataUseCase> {
        SaveParentsDataUseCase(user_parents_data_repository = get())
    }

    factory<GetPersonalData1UseCase> {
        GetPersonalData1UseCase(user_personal_data_1_repository = get())
    }
    factory<GetPersonalData2UseCase> {
        GetPersonalData2UseCase(user_personal_data_2_repository = get())
    }
    factory<GetParentsDataUseCase> {
        GetParentsDataUseCase(user_parents_data_repository = get())
    }

}