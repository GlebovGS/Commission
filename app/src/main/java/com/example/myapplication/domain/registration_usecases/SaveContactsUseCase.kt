package com.example.myapplication.domain.registration_usecases

class SaveContactsUseCase(private val user_contacts_repository: IUserContactsRepository) {
    fun saveEmail(p0:String):Boolean{
        return user_contacts_repository.emailSave(p0)
    }
    fun savePhoneNumber(p0:String):Boolean{
        return user_contacts_repository.phoneNumberSave(p0)
    }
    fun saveOtherContacts(p0:String):Boolean{
        return user_contacts_repository.otherContactsSave(p0)
    }
}