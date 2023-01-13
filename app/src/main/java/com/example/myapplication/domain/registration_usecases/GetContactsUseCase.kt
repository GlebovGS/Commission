package com.example.myapplication.domain.registration_usecases

class GetContactsUseCase(private val user_contacts_respository: IUserContactsRepository) {

    fun getEmail():String{
        return user_contacts_respository.emailGet()
    }

    fun getPhoneNumber():String{
        return user_contacts_respository.phoneNumberGet()
    }

    fun getOtherContacts():String{
        return user_contacts_respository.otherContactsGet()
    }

}