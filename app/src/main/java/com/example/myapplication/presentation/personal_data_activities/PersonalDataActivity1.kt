package com.example.myapplication.presentation.personal_data_activities

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.myapplication.databinding.ActivityPersonalData1Binding
import org.koin.androidx.viewmodel.ext.android.viewModel


class PersonalDataActivity1 : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalData1Binding

    private val personalData1VM by viewModel<PersonalData1ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalData1Binding.inflate(layoutInflater)

        setContentView(binding.root)

        personalData1VM.validationResult1.observe(this) {
            if (it.errorMassage != null) {
                binding.editTextUserItizenship.error = it.errorMassage
            }
        }
        personalData1VM.validationResult2.observe(this) {
            if (it.errorMassage != null) {
                binding.editTextUserINN.error = it.errorMassage
            }
        }

        binding.btnNext.setOnClickListener{
            val userCitizenship= binding.editTextUserItizenship.text.toString().trim()
            val userINN = binding.editTextUserINN.text.toString().trim()

            val selectedRB = binding.radioGroupLanguages.checkedRadioButtonId
            val userLearningLanguage = findViewById<RadioButton>(selectedRB)

            personalData1VM.save(userCitizenship,userINN,userLearningLanguage.text.toString())

            if(binding.editTextUserItizenship.error==null&&
                binding.editTextUserINN.error==null)
            {
                val intent = Intent(this, PersonalDataActivity2::class.java)
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }
        }
    }
}