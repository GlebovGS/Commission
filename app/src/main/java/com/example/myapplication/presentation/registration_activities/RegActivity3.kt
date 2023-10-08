package com.example.myapplication.presentation.registration_activities

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.ActivityReg3Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityReg3Binding

    private val reg3VM by viewModel<Reg3ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReg3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        reg3VM.validationResult1.observe(this) {
            if (it.errorMassage != null) {
                binding.editTextUserLogin.error = it.errorMassage
            }
        }
        reg3VM.validationResult2.observe(this) {
            if (it.errorMassage != null) {
                binding.editTextUserPassword.error = it.errorMassage
            }
        }
        reg3VM.validationResult3.observe(this){
            if (it.errorMassage != null) {
                binding.editTextUserConfirmPassword.error = it.errorMassage
            }
        }

        binding.btnNext.setOnClickListener{
            val userLogin = binding.editTextUserLogin.text.toString().trim()
            val userPassword = binding.editTextUserPassword.text.toString().trim()
            val userRepeatedPassword = binding.editTextUserConfirmPassword.text.toString().trim()
            reg3VM.save(userLogin, userPassword ,userRepeatedPassword)

            if(binding.editTextUserLogin.error==null&&
                binding.editTextUserPassword.error==null&&
                binding.editTextUserConfirmPassword.error==null)
            {
                val intent = Intent(this, RegActivity4::class.java)
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }
        }

        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}