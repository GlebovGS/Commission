package com.example.myapplication.presentation

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.presentation.addition_documents_activities.AdditionDocumentsActivity
import com.example.myapplication.presentation.addition_documents_activities.AdditionPhotoActivity
import com.example.myapplication.presentation.application_form_activities.ApplicationFormActivity1
import com.example.myapplication.presentation.application_form_activities.ApplicationFormActivity2
import com.example.myapplication.presentation.login_activities.LoginActivity
import com.example.myapplication.presentation.personal_data_activities.ConfirmPersonalDataActivity
import com.example.myapplication.presentation.personal_data_activities.PersonalDataActivity3
import com.example.myapplication.presentation.registration_activities.ConfirmRegActivity
import com.example.myapplication.presentation.registration_activities.RegActivity1

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val intent= Intent(this, AdditionPhotoActivity::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        binding.btnRegistration.setOnClickListener{
            val intent= Intent(this, RegActivity1::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}