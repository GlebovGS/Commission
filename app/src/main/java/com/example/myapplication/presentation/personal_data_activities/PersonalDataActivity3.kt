package com.example.myapplication.presentation.personal_data_activities

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.ActivityPersonalData3Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonalDataActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalData3Binding

    private val personalData3VM by viewModel<PersonalData3ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalData3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        personalData3VM.validationResult1.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserFatherLastname.error = it.errorMassage
            }
        })
        personalData3VM.validationResult2.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserFatherName.error = it.errorMassage
            }
        })
        personalData3VM.validationResult3.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserFatherPatronymic.error = it.errorMassage
            }
        })
        personalData3VM.validationResult4.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserFatherPhone.error = it.errorMassage
            }
        })
        personalData3VM.validationResult5.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserMotherLastname.error = it.errorMassage
            }
        })
        personalData3VM.validationResult6.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserMotherName.error = it.errorMassage
            }
        })
        personalData3VM.validationResult7.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserMotherPatronymic.error = it.errorMassage
            }
        })
        personalData3VM.validationResult8.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserMotherPhone.error = it.errorMassage
            }
        })

        binding.btnNext.setOnClickListener{
            goNext()
        }

        binding.btnBack.setOnClickListener{
            finish()
        }

    }

    fun goNext(){

        val fatherLastName = binding.editTextUserFatherLastname.text.toString().trim()
        val fatherName  = binding.editTextUserFatherName.text.toString().trim()
        val fatherPatronymic  = binding.editTextUserFatherPatronymic.text.toString().trim()
        val fatherPhone = binding.editTextUserFatherPhone.text.toString().trim()
        val fatherAddress = binding.editTextUserFatherAddress.text.toString().trim()

        val motherLastName = binding.editTextUserMotherLastname.text.toString().trim()
        val motherName  = binding.editTextUserMotherName.text.toString().trim()
        val motherPatronymic  = binding.editTextUserMotherPatronymic.text.toString().trim()
        val motherPhone = binding.editTextUserMotherPhone.text.toString().trim()
        val motherAddress = binding.editTextUserMotherAddress.text.toString().trim()

        personalData3VM.save(fatherLastName,fatherName,fatherPatronymic,fatherPhone,fatherAddress,
                            motherLastName,motherName,motherPatronymic,motherPhone,motherAddress)

        if( binding.editTextUserFatherLastname.error==null&&
            binding.editTextUserFatherName.error==null&&
            binding.editTextUserFatherPatronymic.error==null&&
            binding.editTextUserFatherPhone.error==null&&
            binding.editTextUserFatherAddress.error==null&&
            binding.editTextUserMotherLastname.error==null&&
            binding.editTextUserMotherName.error==null&&
            binding.editTextUserMotherPatronymic.error==null&&
            binding.editTextUserMotherPhone.error==null&&
            binding.editTextUserMotherAddress.error==null)
        {
            val intent = Intent(this, ConfirmPersonalDataActivity::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }

}