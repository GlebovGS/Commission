package com.example.myapplication.presentation.dependency_injection

import com.example.myapplication.data.personal_data_repositories.UserParentsDataRepositoryImpl
import com.example.myapplication.data.personal_data_repositories.UserPersonalData1RepositoryImpl
import com.example.myapplication.data.personal_data_repositories.UserPersonalData2RepositoryImpl
import com.example.myapplication.data.registration_repositories.UserContactsRepositoryImpl
import com.example.myapplication.data.registration_repositories.UserDateRepositoryImpl
import com.example.myapplication.data.registration_repositories.UserLoginPasswordRepositoryImpl
import com.example.myapplication.data.registration_repositories.UserNameRepositoryImpl
import com.example.myapplication.domain.personal_data_usecases.IUserParentsDataRepository
import com.example.myapplication.domain.personal_data_usecases.IUserPersonalData1Repository
import com.example.myapplication.domain.personal_data_usecases.IUserPersonalData2Repository
import com.example.myapplication.domain.registration_usecases.IUserContactsRepository
import com.example.myapplication.domain.registration_usecases.IUserDateRepository
import com.example.myapplication.domain.registration_usecases.IUserLoginPasswordRepository
import com.example.myapplication.domain.registration_usecases.IUserNameRepository
import org.koin.dsl.module


val dataModule = module{

    single <IUserNameRepository>{
        UserNameRepositoryImpl(context = get())
    }
    single <IUserLoginPasswordRepository>{
        UserLoginPasswordRepositoryImpl(context = get())
    }
    single <IUserDateRepository>{
        UserDateRepositoryImpl(context = get())
    }
    single <IUserContactsRepository>{
        UserContactsRepositoryImpl(context = get())
    }



    single <IUserPersonalData1Repository>{
        UserPersonalData1RepositoryImpl(context = get())
    }
    single <IUserPersonalData2Repository>{
        UserPersonalData2RepositoryImpl(context = get())
    }
    single <IUserParentsDataRepository>{
        UserParentsDataRepositoryImpl(context = get())
    }

}