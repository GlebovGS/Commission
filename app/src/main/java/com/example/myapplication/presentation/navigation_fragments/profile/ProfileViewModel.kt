package com.example.myapplication.presentation.navigation_fragments.profile

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.addition_documents_usecases.GetPhotoUseCase
import com.example.myapplication.domain.registration_usecases.GetNameUseCase

class ProfileViewModel(private val getPhotoUseCase: GetPhotoUseCase,
                       private val getNameUseCase: GetNameUseCase) : ViewModel() {

    val user_name = MutableLiveData<String>()
    val user_photo = MutableLiveData<Bitmap>()

    fun getName(){
        val userName = getNameUseCase.getName()
        val userLastname = getNameUseCase.getLastName()
        val userPatronymic = getNameUseCase.getPatronymic()
        user_name.value = "$userLastname $userName $userPatronymic"
    }

    fun getPhoto(){
        user_photo.value = getPhotoUseCase.getPhoto()
    }
}